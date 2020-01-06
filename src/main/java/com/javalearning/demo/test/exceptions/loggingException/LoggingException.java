package com.javalearning.demo.test.exceptions.loggingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LoggingException {
    private static Logger logger = LoggerFactory.getLogger("loggingException");
    public static void Log(Exception e){
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.info(stringWriter.toString());
    }
}
