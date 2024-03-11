package com.ds.algo.LLD.Logger.Model;

public abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;


    Logger nextLogger;

    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(int logLevel, String message) {
        if (this.nextLogger != null) {
            nextLogger.log(logLevel, message);
        }
    }
}
