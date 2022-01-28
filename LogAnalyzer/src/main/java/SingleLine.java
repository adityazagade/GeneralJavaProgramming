import java.util.ArrayList;

public class SingleLine {
    long lineNumber;
    String timestamp;
    String logLevel;
    String className;
    String threadName;
    String message;
    ArrayList<Long> lineInLogFile;

    public ArrayList<Long> getLineInLogFile() {
        return lineInLogFile;
    }

    public void setLineInLogFile(ArrayList<Long> lineInLogFile) {
        this.lineInLogFile = lineInLogFile;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SingleLine(long lineNumber, String timestamp, String logLevel, String className, String threadName, String message, ArrayList<Long> lineInLogFile) {
        this.lineNumber = lineNumber;
        this.timestamp = timestamp;
        this.logLevel = logLevel;
        this.className = className;
        this.threadName = threadName;
        this.message = message;
        this.lineInLogFile = lineInLogFile;
    }
}
