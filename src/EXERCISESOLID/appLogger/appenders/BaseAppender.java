package EXERCISESOLID.appLogger.appenders;

import EXERCISESOLID.appLogger.enums.ReportLevel;
import EXERCISESOLID.appLogger.layouts.Layout;

public abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppended;

    public BaseAppender(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return layout;
    }

    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    public int getMessagesAppended() {
        return messagesAppended;
    }

    public void setMessagesAppended(int messagesAppended) {
        this.messagesAppended = messagesAppended;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected boolean checkReportLevel(ReportLevel reportLevel) {
        return this.getReportLevel().ordinal() <= reportLevel.ordinal();
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName()
                , this.layout.getClass().getSimpleName()
                , this.getReportLevel()
                , this.getMessagesAppended());
    }
}
