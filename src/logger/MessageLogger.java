package logger;


public class MessageLogger implements Logger {
    public MessageLogger(Appender appender, Appender consoleAppender) {

    }

    public MessageLogger(Appender consoleAppender) {

    }

    @Override
    public void logError(String dateAndTime, String errorMessage) {
        System.out.printf("%s - %s - %s%n",dateAndTime,ReportLevel.ERROR,errorMessage);
    }

    @Override
    public void logInfo(String dateAndTime, String infoMessage) {
        System.out.printf("%s - %S - %s%n",dateAndTime,ReportLevel.INFO,infoMessage);
    }

    @Override
    public void logFatal(String dateAndTime, String fatalError) {
        StringBuilder sb = new StringBuilder("<log>");
        sb.append(System.lineSeparator());
        sb.append("\t");
        sb  .append("<date>").append(dateAndTime).append("</date>");
        sb.append(System.lineSeparator()).append("\t")
                .append("<level>").append(ReportLevel.FATAL).append("</level>")
                .append(System.lineSeparator())
                .append("</log>").append(System.lineSeparator());

        System.out.println(sb.toString().trim());
    }

    @Override
    public void logCritical(String dateAndTime, String criticalMessage) {

        String sb = "<log>" + System.lineSeparator() +
                "\t" +
                "<date>" + dateAndTime + "</date>" +
                System.lineSeparator() + "\t" +
                "<level>"+ReportLevel.CRITICAL+"</level>" +
                System.lineSeparator() +
                "</log>" + System.lineSeparator();
        System.out.println(sb.trim());

    }

    @Override
    public void logWarning(String dateAndTime, String warningMessage) {

    }
}
