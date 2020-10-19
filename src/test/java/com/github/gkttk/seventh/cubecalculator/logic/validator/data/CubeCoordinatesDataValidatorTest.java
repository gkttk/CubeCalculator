package com.github.gkttk.seventh.cubecalculator.logic.validator.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CubeCoordinatesDataValidatorTest {

    private static final DataValidator COORDINATES_DATA_FILTER = new CubeCoordinatesDataValidator();
    private static final String CORRECT_TEST_LINE = "1 2.5 -15 85 0 -4.35654 1 2.5 " +
            "-15 85 0 -4.35654 1 2.5 -15 85 0 -4.35654 1 2.5 -15 85 0 -4.35654";
    private static final String INCORRECT_TEST_LINE = "1 2.5 -15 85 0 -4.35654DSD 1 2.5 " +
            "-15 85 0 -4.35654 1 2.5 -15 85 0 -4.35654 1 2.5 -15 85 0 -4.35654";


    @Test
    public void testValidateShouldReturnTrueWhenValidatingStringIsCorrect() {
        //given
        //when
        boolean testResult = COORDINATES_DATA_FILTER.validate(CORRECT_TEST_LINE);
        //then
        Assertions.assertTrue(testResult);
    }

    @Test
    public void testValidateShouldReturnFalseWhenValidatingStringIsIncorrect() {
        //given
        //when
        boolean testResult = COORDINATES_DATA_FILTER.validate(INCORRECT_TEST_LINE);
        //then
        Assertions.assertFalse(testResult);
    }


}
