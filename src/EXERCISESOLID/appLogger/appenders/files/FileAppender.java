package EXERCISESOLID.appLogger.appenders.files;

import EXERCISESOLID.appLogger.appenders.BaseAppender;
import EXERCISESOLID.appLogger.enums.ReportLevel;
import EXERCISESOLID.appLogger.layouts.Layout;

public class FileAppender extends BaseAppender {

    private File file;
    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if(super.checkReportLevel(reportLevel)) {
            this.file.write(super.getLayout().format(dateTime, reportLevel, message));
            super.setMessagesAppended(super.getMessagesAppended() + 1);
        }
    }

    public void setFile(File file){
        this.file = file;
    }


    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
