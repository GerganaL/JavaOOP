package logger;


public interface Appender {
    void setFile(File file);

    void setReportLevel(String error);
}
