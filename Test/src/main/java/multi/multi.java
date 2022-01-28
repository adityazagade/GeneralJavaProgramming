package multi;

public class multi {
    public static void main(String[] args) {
        TwPlatform platform = new TwPlatform();
        platform.start();
//        platform.updateServer();

        Thread t1 = new Thread(() -> {
            //add audit log
            for (int i = 1; i < 10000; i++) {
                String test = "<RemoteAudits version=\"1.0\" sessionId=\"505gw3RVEM" + i + "vWvUNtrlwJ4d1556EJUX1mllAomTspol3\" foreign-name=\"http://10.85.107.31:8080\"><Audits v=\"1.0\"><FileTransfer type=\"34\">C:\\Users\\ksharma\\OneDrive\\Desktop\\file_transfer_remote_session\\file_upload_kunal\\Axeda_Transport_Users_Guide_167779.pdf</FileTransfer></Audits></RemoteAudits>";
                System.out.println(Thread.currentThread().getName() + " about to add for the " + i + " th time");
                platform.addToStorage(test);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

//        Thread t2 = new Thread(() -> {
//            //add audit log
//            for (int i = 0; i < 1000; i++) {
//                String test = "<RemoteAudits version=\"1.0\" sessionId=\"asdasdasd\" foreign-name=\"http://10.85.107.31:8080\"><Audits v=\"1.0\"><FileTransfer type=\"34\">C:\\Users\\ksharma\\OneDrive\\Desktop\\file_transfer_remote_session\\file_upload_kunal\\Axeda_Transport_Users_Guide_167779.pdf</FileTransfer></Audits></RemoteAudits>";
//                platform.addToStorage(test);
//                System.out.println("added for the " + i + "th time");
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t2.start();

        Thread t3 = new Thread(() -> {
            //add audit log
            for (int i = 1; i < 10000; i++) {
                String test = "<RemoteAudits version=\"1.0\" sessionId=\"56328f6d-b0a" + i + "-46a8-bd40-08b0848a6cf9\" foreign-name=\"http://localhost:8080\"><Audits><SessionInfo type=\"16\">1614699588824</SessionInfo><SessionInfo type=\"17\">1614699602363</SessionInfo><SessionInfo type=\"23\">1</SessionInfo><SessionInfo type=\"9\">127.0.0.1</SessionInfo><SessionInfo type=\"15\">127.0.0.1</SessionInfo></Audits></RemoteAudits>";
                System.out.println(Thread.currentThread().getName() + " about to add for the " + i + " th time");
                platform.addToStorage(test);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();

        Thread t4 = new Thread(() -> {
            for (int i = 1; i < 100000; i++) {
                platform.storage.flushStorage();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t4.start();
    }
}
