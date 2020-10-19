package com.github.gkttk.seventh.cubecalculator.data.exception;

/**
 * Wrapper for IOException and FileNotFoundException in FileDataReader.
 */
public class FileDataSupplierException extends Exception {


    public FileDataSupplierException(String message, String wrongFileLocation, Throwable cause) {
        super(message, cause);
        System.out.println("Wrong file location: " + wrongFileLocation);
    }


}
