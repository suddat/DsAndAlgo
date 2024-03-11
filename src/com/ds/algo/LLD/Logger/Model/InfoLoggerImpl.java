package com.ds.algo.LLD.Logger.Model;

public class InfoLoggerImpl extends Logger {
    public InfoLoggerImpl(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int logLevel, String message) {
        if (logLevel == INFO) {
            System.out.println("INFO : " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
