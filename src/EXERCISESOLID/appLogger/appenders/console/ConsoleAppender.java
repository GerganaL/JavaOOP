package EXERCISESOLID.appLogger.appenders.console;

import EXERCISESOLID.appLogger.appenders.BaseAppender;
import EXERCISESOLID.appLogger.enums.ReportLevel;
import EXERCISESOLID.appLogger.layouts.Layout;

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
