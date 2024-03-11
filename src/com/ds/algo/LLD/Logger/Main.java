package com.ds.algo.LLD.Logger;

import com.ds.algo.LLD.Logger.Model.DebugLoggerImpl;
import com.ds.algo.LLD.Logger.Model.ErrorLoggerImpl;
import com.ds.algo.LLD.Logger.Model.InfoLoggerImpl;
import com.ds.algo.LLD.Logger.Model.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = new InfoLoggerImpl(new DebugLoggerImpl(new ErrorLoggerImpl(null)));

        logger.log(Logger.DEBUG, "debug the issue");
        logger.log(Logger.ERROR, "exception");
        logger.log(Logger.INFO, "INFO the logs");

    }
}
