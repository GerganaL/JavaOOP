package EXERCISESOLID.appLogger.layouts;


import EXERCISESOLID.appLogger.enums.ReportLevel;

public interface Layout {
    String format(String dateTime, ReportLevel reportLevel, String message);
}
