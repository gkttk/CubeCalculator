package com.github.gkttk.seventh.cubecalculator.data;

import com.github.gkttk.seventh.cubecalculator.data.exception.FileDataSupplierException;

import java.util.List;

/**
 * Common interface for DataReader.
 */
public interface DataReader {

    List<String> readLines(String fileLocation) throws FileDataSupplierException;

}
