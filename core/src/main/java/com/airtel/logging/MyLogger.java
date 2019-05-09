package com.airtel.logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class MyLogger implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public Logger logger = null;

    public MyLogger() {
        logger = Logger.getLogger(MyLogger.class);
    }

    public MyLogger(Logger logger1) {
        this.logger = logger1;
    }

    public static MyLogger getLoggerObject(Class<?> className) {
        Logger logger = LogManager.getLogger(className);
        return new MyLogger(logger);
    }


    public void info(String s) {
        logger.info(s);
    }

    public void error(String s, Exception e) {
        logger.error(s, e);
    }

    public void error(Object e) {
        logger.error(e);
    }

    public void error(String s) {
        logger.error(s);
    }

    public void error(String s, Throwable e) {
        logger.error(s, e);
    }

}

