package com.company;

import java.sql.Timestamp;
import java.util.Date;


public class Logger {

    private static final String INFO_WHITE = "\u001B[37m";
    private static final String DEBUG_BLUE = "\u001B[34m";
    private static final String WARN_YELLOW = "\u001B[33m";
    private static final String ERROR_RED = "\u001B[31m";


    public void printMessage(String message, String Color) {
        Date date = new Date();
        System.out.print(Color);
        System.out.print(new Timestamp(date.getTime()));
        System.out.println(" " + message);
    }

    public void info(String message) {
        printMessage(message, INFO_WHITE);
    }

    public void debug(String message) {
        printMessage(message, DEBUG_BLUE);
    }

    public void warn(String message) {
        printMessage(message, WARN_YELLOW);
    }

    public void error(String message) {
        printMessage(message, ERROR_RED);
    }

    public static void main(String[] args) {

        Logger logger = new Logger();

        logger.info("This is INFO");
        logger.debug("This is DEBUG");
        logger.warn("This is WARN");
        logger.error("This is ERROR");
    }
}
