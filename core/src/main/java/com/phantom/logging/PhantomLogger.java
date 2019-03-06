package com.phantom.logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.Serializable;

public class PhantomLogger implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public Logger logger = null;

    public PhantomLogger() {
        logger = Logger.getLogger(PhantomLogger.class);
    }

    public PhantomLogger(Logger logger1) {
        this.logger = logger1;
    }

    public static PhantomLogger getLoggerObject(Class<?> className) {
        Logger logger = LogManager.getLogger(className);
        return new PhantomLogger(logger);
    }

    public void info(Object s) {
        logger.info(s);
    }

    public void info(String s) {
        logger.info(s);
    }

    public void warn(Object s, Exception e) {
        logger.warn(s, e);
    }

    public void info(String s, Throwable e) {
        logger.info(s, e);
    }

    public void warn(Object s) {
        logger.warn(s);
    }

    public void warn(Object s, Throwable e) {
        logger.warn(s, e);
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

    public void trace(String s) {
        logger.trace(s);
    }

    public void trace(Object s) {
        logger.trace(s);
    }

    public void error(String s, Throwable e) {
        logger.error(s, e);
    }

    public void debug(Object s) {
        logger.debug(s);
    }
}

