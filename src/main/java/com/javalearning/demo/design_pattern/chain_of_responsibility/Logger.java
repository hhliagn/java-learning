package com.javalearning.demo.design_pattern.chain_of_responsibility;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Consumer;

@FunctionalInterface
public interface Logger {

    public enum LoggerLevel {
        INFO, DEBUG, WARNING, ERROR, FUNCTIONAL_MESSAGE, FUNCTIONAL_ERROR;

        public static LoggerLevel[] all(){
            return values();
        }
    }

    abstract void message(String message, LoggerLevel severity);

    default Logger appendNext(Logger nextLogger){
        return (message, severity) -> {
            message(message, severity);
            nextLogger.message(message, severity);
        };
    }

    static Logger writeLogger(LoggerLevel[] logLevels, Consumer<String> consumer){
        EnumSet<LoggerLevel> set = EnumSet.copyOf(Arrays.asList(logLevels));
        return (message, severity) -> {
            if (set.contains(severity)){
                consumer.accept(message);
            }
        };
    }

    static Logger consoleLogger(LoggerLevel... logLevels){
        return writeLogger(logLevels, msg -> System.out.println("console log: " + msg));
    }

    static Logger emailLogger(LoggerLevel... logLevels){
        return writeLogger(logLevels, msg -> System.out.println("email log: " + msg));
    }

    static Logger fileLogger(LoggerLevel... logLevels){
        return writeLogger(logLevels, msg -> System.out.println("file log: " + msg));
    }

    public static void main(String[] args) {

        Logger logger = consoleLogger(LoggerLevel.all())
                .appendNext(emailLogger(LoggerLevel.FUNCTIONAL_MESSAGE, LoggerLevel.FUNCTIONAL_ERROR))
                .appendNext(fileLogger(LoggerLevel.WARNING, LoggerLevel.ERROR));

        logger.message("to console1..", LoggerLevel.DEBUG);
        logger.message("to console2..", LoggerLevel.INFO);

        logger.message("to email1..", LoggerLevel.FUNCTIONAL_MESSAGE);
        logger.message("to email2..", LoggerLevel.FUNCTIONAL_ERROR);

        logger.message("to file1..", LoggerLevel.WARNING);
        logger.message("to file2..", LoggerLevel.ERROR);
    }

}
