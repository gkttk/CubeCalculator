package com.github.gkttk.seventh.cubecalculator.data;

import com.github.gkttk.seventh.cubecalculator.data.exception.FileDataSupplierException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for read all lines from given file.
 */
public class FileDataReader implements DataReader {

    @Override
    public List<String> readLines(String fileLocation) throws FileDataSupplierException {
        List<String> linesFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                linesFromFile.add(line);
            }
        } catch (IOException exception) {
            throw new FileDataSupplierException("Trouble with reading the file.", fileLocation, exception);
        }

        return linesFromFile;
    }
}
