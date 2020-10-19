package com.github.gkttk.seventh.cubecalculator.logic.exception;

/**
 * This exception throws when a parallel plane does not cut a cube.
 */
public class DataParserException extends Exception {

    public DataParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
