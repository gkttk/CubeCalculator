package com.github.gkttk.seventh.cubecalculator.data;

import com.github.gkttk.seventh.cubecalculator.data.exception.FileDataSupplierException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestFileDataReader {

    private static final String FILE_LOCATION = "src\\test\\resources\\eightcubesfiletest.txt";
    private static final DataReader FILE_DATA_SUPPLIER = new FileDataReader();

    @Test
    public void testReadLinesShouldReadAllLinesFromGivenFileWhenGivenFileLocationIsCorrect() throws FileDataSupplierException {
        //given
        int expectedCountOfLines = 8;
        //when
        List<String> lines = FILE_DATA_SUPPLIER.readLines(FILE_LOCATION);
        //then
        Assertions.assertEquals(expectedCountOfLines, lines.size());
    }


    @Test
    public void testReadLinesShouldThrowAnExceptionWhenGivenFileLocationIsWrong() {
        //given
        String incorrectFileLocation = "thereIsNoSuchFile.txt";
        //when
        //then
        Assertions.assertThrows(FileDataSupplierException.class, () -> FILE_DATA_SUPPLIER.readLines(incorrectFileLocation));

    }


}
