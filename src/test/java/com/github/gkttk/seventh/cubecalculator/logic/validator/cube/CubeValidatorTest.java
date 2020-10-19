package com.github.gkttk.seventh.cubecalculator.logic.validator.cube;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.EdgeCalculator;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CubeValidatorTest {

    private final static CubeValidator CUBE_CHECKER = new CubeValidator();

    @Test
    public void testCheckCubeShouldReturnTrueWhenPointsRepresentCube() {
        //given
        List<Point> cubePoints = Arrays.asList(
                new Point(0, 0, 0),
                new Point(1, 0, 0),
                new Point(1, 0, 1),
                new Point(0, 0, 1),
                new Point(0, 1, 0),
                new Point(1, 1, 0),
                new Point(1, 1, 1),
                new Point(0, 1, 1));
        //when
        boolean result = CUBE_CHECKER.validateCube(cubePoints);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckCubeShouldReturnTrueWhenPointsDoNotRepresentCube() {
        //given
        List<Point> notCubePoints = Arrays.asList(
                new Point(15, 0, 0),
                new Point(1, 0, 0),
                new Point(1, 0, 1),
                new Point(0, 0, 1),
                new Point(0, 1, 0),
                new Point(1, 1, 0),
                new Point(1, 1, 1),
                new Point(0, 1, 1));
        //when
        boolean result = CUBE_CHECKER.validateCube(notCubePoints);
        //then
        Assertions.assertFalse(result);
    }

}
