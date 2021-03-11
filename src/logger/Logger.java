package logger;

public interface Logger {
   void logError(String dateAndTime, String errorMessage) ;

   void logInfo(String dateAndTime, String infoMessage) ;

    void logFatal(String s, String s1);

    void logCritical(String s, String s1);

    void logWarning(String dateAndTime, String warningMessage);
}
