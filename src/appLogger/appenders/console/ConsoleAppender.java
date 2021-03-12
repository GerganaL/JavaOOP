package appLogger.appenders.console;

import appLogger.appenders.BaseAppender;
import appLogger.enums.ReportLevel;
import appLogger.layouts.Layout;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if(super.checkReportLevel(reportLevel)) {
            System.out.println(super.getLayout().format(dateTime, reportLevel, message));
            super.setMessagesAppended(super.getMessagesAppended() + 1);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
