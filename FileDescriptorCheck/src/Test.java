import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Test {
    private final String dir;
    private ScheduledExecutorService pool;
    private final Config c;
    private Map<String, Long> map;

    public Test(Config c) {
        this.c = c;
        this.pool = Executors.newScheduledThreadPool(c.poolSize);
        this.map = new HashMap<>();
        this.dir = Paths.get(c.mountLocation + File.separator + "test").toString();

        File directory = new File(this.dir);
        if (!directory.exists()) {
            System.out.println("Mount directory created: " + directory.mkdir());
        }

        Runtime.getRuntime().addShutdownHook(new Thread(this::shutdown));
    }

    private void shutdown() {
        System.out.println("[Test]: ShutDown called..");
        if (pool == null) return;
        try {
            pool.submit(new CSVLoggerTask());
            pool.shutdown();
            boolean isTerminated = pool.awaitTermination(60, TimeUnit.SECONDS);
            int count = 0;
            while (!isTerminated && count < 2) {
                isTerminated = pool.awaitTermination(60, TimeUnit.SECONDS);
                count++;
            }
            this.pool = null;
            freeResources();
        } catch (InterruptedException e) {
            System.out.println("Could not shutdown ExecutorService in Test: " + e.getMessage());
        }
    }

    private void freeResources() {
        this.map = null;
    }

    private void startSimulation() {
        initPoolWithTasks();
    }

    private void initPoolWithTasks() {
        this.pool.scheduleAtFixedRate(new UploadFileTask(), 0, c.file_upload_freq, TimeUnit.SECONDS);
        this.pool.scheduleAtFixedRate(new DeleteFileTask(), 30, c.file_deletion_freq, TimeUnit.SECONDS);
        this.pool.scheduleAtFixedRate(new CSVLoggerTask(), 45, c.csv_dump_freq, TimeUnit.SECONDS);
    }

    private void endSimulation() {
        shutdown();
    }

    String getTimeStamp() {
        return new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    public static void main(String[] args) throws IOException {

        Properties props = loadProperties();
        Config c = new Config(props);
        Test t = new Test(c);

        long start = System.currentTimeMillis();
        long curr = start;

        t.startSimulation();

        while (curr - start < c.ttl) {
            try {
                Thread.sleep(c.sleepInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            curr = System.currentTimeMillis();
        }

        t.endSimulation();
        System.out.println("[Main]: About to end the test...Wait for a minute.");
    }

    private static Properties loadProperties() throws IOException {
        FileReader fr = null;
        try {
            fr = new FileReader("config.properties");
            Properties p = new Properties();
            p.load(fr);
            return p;
        } catch (IOException e) {
            System.out.println("Error reading config file: " + e.getMessage());
            throw e;
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class UploadFileTask implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("[UploadFileTask]: Running FileUpload Task... @" + getTimeStamp());
                for (int i = 0; i < c.numConcurrentFileUploads; i++) {
                    pool.execute(() -> {
                        FileOutputStream fos;
                        String fileName = "file" + (int) (100000 * Math.random()) + "_" + System.currentTimeMillis() + ".dat_tmp";
                        String path = dir + File.separator + fileName;
                        File f = new File(path);
                        boolean shouldRename = false;
                        try {
                            fos = new FileOutputStream(f);
                            String text = getRandomString();
                            fos.write(text.getBytes(), 0, text.getBytes().length);
                            fos.flush();
                            fos.close();
                            synchronized (map) {
                                map.put(fileName.replace(".dat_tmp", ".dat"), System.currentTimeMillis());
                            }
                            shouldRename = true;
                            System.out.println("[UploadFileTask]: new file created.. " + fileName + " should rename: " + shouldRename);
                        } catch (Exception e) {
                            System.out.println("[UploadFileTask]: Error uploading a new file");
                            e.printStackTrace();
                        } finally {
//                            if (fos != null) {
//                                try {
//                                    fos.close();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
                            if (f.exists() && shouldRename) {
                                File target = null;
                                try {
                                    String path1 = f.getCanonicalPath();
                                    path1 = path1.replace("_tmp", "");
                                    target = new File(path1);
                                    boolean result = f.renameTo(target);
                                    System.out.println("[UploadFileTask]: file: " + f + " renamed: " + result);
                                } catch (IOException e) {
                                    System.out.println("[UploadFileTask]: Error renaming the uploaded file");
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getRandomString() {
        StringBuilder sb = new StringBuilder();
        int times = (int) (100 * Math.random()) + 1;
        for (int i = 0; i < times; i++) {
            sb.append("lorem ipsum");
        }
        return sb.toString();
    }

    class DeleteFileTask implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("[DeleteFileTask]: Running DeleteFile Task...@" + getTimeStamp());
                long curr = System.currentTimeMillis();
                ArrayList<String> l = new ArrayList<>();
                for (Map.Entry<String, Long> item : map.entrySet()) {
                    String fileName = item.getKey();
                    long ts = item.getValue();
                    long delta = c.file_deletion_threshold * 1000L;
                    if (curr - ts > delta) {
                        String path = dir + File.separator + fileName;
                        File f = new File(path);
                        boolean isDeleted = f.delete();
                        if (isDeleted) {
                            l.add(fileName);
                        }
                        System.out.println("[DeleteFileTask]: file deleted.. " + fileName + " : " + isDeleted);
                    }
                }

                synchronized (map) {
                    l.forEach(fName -> map.remove(fName));
                }
            } catch (Exception e) {
                System.out.println("[DeleteFileTask]: Error executing delete task... " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    class CSVLoggerTask implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("[CSVLoggerTask]: Running CSV Logger Task...@" + getTimeStamp());
                long size = size(Paths.get(dir));
                String path = "dirSizeGrowth.csv";
                FileWriter fw = null;
                try {
                    fw = new FileWriter(path, true);
                    String sb = System.currentTimeMillis() + ";" +
                            size + ";" +
                            map + ";" +
                            Arrays.toString(new File(dir).list()) + System.lineSeparator();
                    fw.write(sb);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("[CSVLoggerTask]: Error executing csv dump task... " + e.getMessage());
                e.printStackTrace();
            }
        }

        public long size(Path path) {
            final AtomicLong size = new AtomicLong(0);

            try {
                Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        size.addAndGet(attrs.size());
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        System.out.println("[CSVLoggerTask]: skipped: " + file + " (" + exc + ")");
                        // Skip folders that can't be traversed
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {

                        if (exc != null)
                            System.out.println("[CSVLoggerTask]: had trouble traversing: " + dir + " (" + exc + ")");
                        // Ignore errors traversing a folder
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                throw new AssertionError("[CSVLoggerTask]: walkFileTree will not throw IOException if the FileVisitor does not");
            }

            return size.get();
        }
    }

}

class Config {
    public int file_deletion_threshold;
    public String mountLocation;
    public long ttl;
    public long sleepInterval;
    int file_upload_freq;
    int file_deletion_freq;
    int csv_dump_freq;
    int poolSize;
    int numConcurrentFileUploads;

    public Config(Properties p) {
        try {
            this.file_upload_freq = Integer.parseInt(p.getProperty("file_upload_freq"));
            this.file_deletion_freq = Integer.parseInt(p.getProperty("file_deletion_freq"));
            this.file_deletion_threshold = Integer.parseInt(p.getProperty("file_deletion_threshold"));
            this.numConcurrentFileUploads = Integer.parseInt(p.getProperty("num_concurrent_file_uploads"));
            this.csv_dump_freq = Integer.parseInt(p.getProperty("csv_dump_freq"));
            this.poolSize = Integer.parseInt(p.getProperty("pool_size"));
            this.mountLocation = p.getProperty("mountLocation");
            this.ttl = Long.parseLong(p.getProperty("time_to_run")) * 60 * 1000;
            this.sleepInterval = Long.parseLong(p.getProperty("main_thread_sleep_interval")) * 1000;
        } catch (Exception e) {
            System.out.println("Error creating config obj: " + e.getMessage());
            throw e;
        }
    }
}