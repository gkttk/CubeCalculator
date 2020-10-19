package com.github.gkttk.seventh.cubecalculator.data.factory;

import com.github.gkttk.seventh.cubecalculator.data.DataReader;

/**
 * Common interface for DataReader factories.
 */
public interface DataReaderFactory {
    DataReader createDataReader();

}
