package com.ds.algo.LLD.Logger.Model;

public class DebugLoggerImpl extends Logger {
    public DebugLoggerImpl(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int logLevel, String message) {
        if(logLevel == DEBUG){
            System.out.println("DEBUG : " + message);
        }else{
            super.log(logLevel, message);
        }
    }
}
