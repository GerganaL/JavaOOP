package appLogger.layouts;


import appLogger.enums.ReportLevel;

public interface Layout {
    String format(String dateTime, ReportLevel reportLevel, String message);
}
