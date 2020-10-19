package com.github.gkttk.seventh.cubecalculator.data.factory;

import com.github.gkttk.seventh.cubecalculator.data.DataReader;
import com.github.gkttk.seventh.cubecalculator.data.FileDataReader;

/**
 * Factory for FileDataReader.
 */
public class FileDataReaderFactory implements DataReaderFactory {

    @Override
    public DataReader createDataReader() {
        return new FileDataReader();
    }
}
