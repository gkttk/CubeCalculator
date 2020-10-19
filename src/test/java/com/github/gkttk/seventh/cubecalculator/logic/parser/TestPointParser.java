package com.github.gkttk.seventh.cubecalculator.logic.parser;

import com.github.gkttk.seventh.cubecalculator.logic.exception.DataParserException;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPointParser {


    private final static DataParser<List<Point>, String> POINT_PARSER = new PointParser();
    private static final String CORRECT_TEST_LINE = "1 2.5 -15 85 0 -4.35654 1 2.5 " +
            "-15 85 0 -4.35654 1 2.5 -15 85 0 -4.35654 1 2.5 -15 85 0 -4.35654";
    private static final String INCORRECT_TEST_LINE = "1a 2.5 -15 85 0 -4.35654 1 2.5 " +
            "-15 85 0 -4.35654 1 2.5 -15 85 0 -4.35654 1 2.5 -15 85 0 -4.35654";

    @Test
    public void testParseShouldReturnListOfPointsWhenGivenLineIsCorrect() throws DataParserException {
        //given
        int expectedPointsListSize = 8;
        //when
        List<Point> testResult = POINT_PARSER.parse(CORRECT_TEST_LINE);
        //then
        Assertions.assertEquals(expectedPointsListSize, testResult.size());
    }

    @Test
    public void testParseShouldThrowsExceptionWhenReceivesAnIncorrectLine() {
        //given
        //when
        //then
        Assertions.assertThrows(DataParserException.class, () -> POINT_PARSER.parse(INCORRECT_TEST_LINE));


    }


}
