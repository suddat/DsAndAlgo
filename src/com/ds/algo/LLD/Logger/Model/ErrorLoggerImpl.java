package com.ds.algo.LLD.Logger.Model;

public class ErrorLoggerImpl extends Logger {
    public ErrorLoggerImpl(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(int logLevel, String message) {
        if(logLevel == ERROR){
            System.out.println("ERROR : " + message);
        }else{
            super.log(logLevel, message);
        }
    }
}
