package EXERCISESOLID.appLogger;


import EXERCISESOLID.appLogger.appenders.Appender;
import EXERCISESOLID.appLogger.appenders.console.ConsoleAppender;

import EXERCISESOLID.appLogger.appenders.files.FileAppender;
import EXERCISESOLID.appLogger.appenders.files.LogFile;
import EXERCISESOLID.appLogger.enums.ReportLevel;
import EXERCISESOLID.appLogger.layouts.Layout;
import EXERCISESOLID.appLogger.layouts.SimpleLayout;

import EXERCISESOLID.appLogger.layouts.XmlLayout;
import EXERCISESOLID.appLogger.loggers.Logger;
import EXERCISESOLID.appLogger.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Appender> appenders = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] appenderInfo = reader.readLine().split("\\s+");
            Appender appender = createAppender(appenderInfo);
            if(appenderInfo.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(appenderInfo[2].toUpperCase()));
            }else {
                appender.setReportLevel(ReportLevel.INFO);
            }
            appenders.add(appender);
        }

        Logger logger = new MessageLogger(appenders.toArray(appenders.toArray(new Appender[n])));

        String line = reader.readLine();
        while (!line.equals("END")){
            String[] tokens = line.split("\\|");
            ReportLevel level = ReportLevel.valueOf(tokens[0]);

            switch (level){
                case INFO:
                    logger.logInfo(tokens[1],tokens[2]);
                    break;
                case WARNING:
                    logger.logWarning(tokens[1],tokens[2]);
                    break;
                case FATAL:
                    logger.logFatal(tokens[1],tokens[2]);
                    break;
                case CRITICAL:
                    logger.logCritical(tokens[1],tokens[2]);
                    break;
                case ERROR:
                    logger.logError(tokens[1],tokens[2]);
                    break;
            }

            line = reader.readLine();
        }

        System.out.println(logger.logInfo());

    }

    public static Appender createAppender(String[] tokens) {
        switch (tokens[0]){
            case "ConsoleAppender":
                return new ConsoleAppender(crateLayout(tokens[1]));
            case "FileAppender":
                FileAppender fileAppender = new FileAppender(crateLayout(tokens[1]));
                fileAppender.setFile(new LogFile());
                return fileAppender;
            default:
                throw new IllegalArgumentException("Invalid appender!");
        }
    }

    public static  Layout crateLayout(String layout){
        switch (layout){
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw  new IllegalArgumentException("Invalid layout");
        }
    }
}
