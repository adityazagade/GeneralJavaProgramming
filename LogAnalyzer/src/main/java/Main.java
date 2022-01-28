import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Main {

    HashMap<String, Integer> frequency = new HashMap<>();
    List<SingleLine> linesForThreadT = new ArrayList<>();
    List<SingleLine> linesContainingThisQuery = new ArrayList<>();
    List<SingleLine> linesForThreadTOfThisQuery = new ArrayList<>();
    SimpleDateFormat sformat = new SimpleDateFormat("HH:mm:ss,SSS");

    public static void main(String[] args) {
        Main main = new Main();
        File file = new File("C:\\developer\\Axeda\\ISSUES_PSPT_SPIKE\\PSPT-70191_Philipps\\Philips\\node2_server_beforerestart.log");
//      File file = new File("C:\\developer\\Axeda\\ISSUES_PSPT_SPIKE\\PSPT-70191_Philipps\\Philips\\node2_server_beforerestart.log");
        String startT = "06:30:00,000";
        String endT = "11:30:00,000";

        String threadNameQueried = "triggerableEventJmsListenerTemplate-63";
        String messageQueried = "it has exceeded the maximum allowed processing duration of 5 minutes";
        messageQueried = "disabling stand alone rule named";

        main.processLogs(file, startT, endT, threadNameQueried, messageQueried);
        main.printReports();
    }

    private void printReports() {
//        printFrequency();
        System.out.println("*********************************");
//        printFrequencyWhoseAreGreaterThanN(20);
        System.out.println("*********************************");
        //printLinesOfThisThead();
        System.out.println("*********************************");
        printLinesContainingThisMessage();
        System.out.println("*********************************");
        //printLinesOfThisThreadContainingThisMessage();
    }

    private void processLogs(File file, String startT, String endT, String threadNameQueried, String messageQueried) {
        long lineNumber = 0;
        try {
            Date startTime = sformat.parse(startT);
            Date endTime = sformat.parse(endT);
            BufferedReader r = new BufferedReader(new FileReader(file));
            StringBuilder logLine = new StringBuilder();
            String line = r.readLine();
            ArrayList<Long> linesInLog = new ArrayList<>();
            long lineInLog = 0;
            boolean firstTime = true;
            while (line != null) {
                lineInLog++;
                try {
                    Date currDate = sformat.parse(line.split(" ")[0]);
                    lineNumber++;
                    // if we reached here that means the line starts with dateStamp.
                    //process previous line first if its not the first time;
                    if (!firstTime) {
                        SingleLine sl = getLineObject(lineNumber, linesInLog, logLine.toString());

                        //check if this the thread those information is requested. Partial match will also do.
                        if (sl.getThreadName().contains(threadNameQueried)) {
                            linesForThreadT.add(sl);
                        }

                        if (sl.getThreadName().contains(threadNameQueried) && sl.getMessage().contains(messageQueried)) {
                            linesForThreadTOfThisQuery.add(sl);
                        }

                        if (sl.getMessage().contains(messageQueried)) {
                            linesContainingThisQuery.add(sl);
                        }

                        Date ts = sformat.parse(sl.getTimestamp());
                        if (ts.after(startTime) && ts.before(endTime)) {
                            if (line.contains("GroupID")) {
                                String[] tt = line.split("GroupID");
                                String groupId = (tt[1].split(" ")[0]).substring(1);
                                Integer count = frequency.get(groupId);
                                if (count == null) {
                                    count = 0;
                                }
                                count++;
                                frequency.put(groupId.trim(), count);

                            }
                        }
//                        //replace oldLine as "".
                        logLine = new StringBuilder();
                        //put partially read Line as inside oldLine
                        logLine.append(line);
                        linesInLog = new ArrayList<>();
                        linesInLog.add(lineInLog);
                    } else {
                        firstTime = false;
                        logLine.append(line);
                        linesInLog.add(lineInLog);
                    }
                } catch (ParseException e) {
                    //This means that the line that we just read was not a new line starting with date.
                    // We should append this to the old line.
                    logLine.append("\r\n");
                    logLine.append(line);
                    linesInLog.add(lineInLog);
//                    e.printStackTrace();
                }
                line = r.readLine();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private SingleLine getLineObject(long lineNumber, ArrayList<Long> linesInLog, String line) {
        String[] temp = line.split(" ");
        int i = 0;
        if (temp[0].equals("")) {
            i++;
        }
        String timestamp = temp[i];
        i++;
        if (temp[1].equals("")) {
            i++;
        }
        String logLevel = temp[i];
        i++;

        if (temp[2].equals("")) {
            i++;
        }
        String className = temp[2];
        i++;

        if (temp[3].equals("")) {
            i++;
        }
        String threadName = temp[i]; // (thread1)

        String mess = line.substring(line.indexOf(threadName) + threadName.length());

        //remove brackets from threadName
        threadName = threadName.replaceAll("\\(", "");
        threadName = threadName.replaceAll("\\)", "");

        return new SingleLine(lineNumber, timestamp, logLevel, className, threadName, mess.trim(), linesInLog);
    }

    private void printLinesContainingThisMessage() {
        linesContainingThisQuery.forEach(sl -> {
//            System.out.println(sl.getThreadName() + " : " + sl.getTimestamp() + " on Line " + sl.getLineNumber());
            System.out.println(sl.getThreadName() + " : " + sl.getTimestamp() + " on Line " + sl.getLineInLogFile().toString() + ": MESSAGE : " + sl.getMessage());
        });
    }

    private void printLinesOfThisThreadContainingThisMessage() {
        linesForThreadTOfThisQuery.forEach(sl -> {
            System.out.println(sl.getThreadName() + " : " + sl.getTimestamp() + " on Line " + sl.getLineNumber());
        });
    }

    private void printLinesOfThisThead() {
        linesForThreadT.forEach(sl -> {
            System.out.println(sl.getThreadName() + " : " + sl.getTimestamp() + " on Line " + sl.getLineNumber());
        });
    }

    void printFrequency() {
        for (String pair : frequency.keySet()) {
            System.out.println("GroupId: " + pair + ": " + frequency.get(pair));
        }
    }

    void printFrequencyWhoseAreGreaterThanN(int n) {
        for (String pair : frequency.keySet()) {
            if (frequency.get(pair) >= n) {
                System.out.println("GroupId: " + pair + ": " + frequency.get(pair));
            }
        }
    }

}
