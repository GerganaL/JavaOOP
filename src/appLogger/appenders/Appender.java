package appLogger.appenders;

import appLogger.enums.ReportLevel;

public interface Appender {
    void append(String dateTime, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
}
