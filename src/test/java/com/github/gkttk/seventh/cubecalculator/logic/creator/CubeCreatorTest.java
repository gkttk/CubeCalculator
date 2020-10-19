package com.github.gkttk.seventh.cubecalculator.logic.creator;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.EdgeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.exception.DataParserException;
import com.github.gkttk.seventh.cubecalculator.logic.parser.DataParser;
import com.github.gkttk.seventh.cubecalculator.logic.parser.PointParser;
import com.github.gkttk.seventh.cubecalculator.logic.validator.cube.CubeValidator;
import com.github.gkttk.seventh.cubecalculator.logic.validator.data.CubeCoordinatesDataValidator;
import com.github.gkttk.seventh.cubecalculator.logic.validator.data.DataValidator;
import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


public class CubeCreatorTest {


    private final static DataValidator CUBE_COORDINATES_DATA_VALIDATOR_MOCK = Mockito.mock(CubeCoordinatesDataValidator.class);
    private final static DataParser<List<Point>, String> POINT_PARSER_MOCK = Mockito.mock(PointParser.class);
    private final static CubeValidator CUBE_VALIDATOR_MOCK = Mockito.mock(CubeValidator.class);
    private final static EdgeCalculator EDGE_CALCULATOR_MOCK = Mockito.mock(EdgeCalculator.class);


    private final static CubeCreator CUBE_CREATOR = new CubeCreator(CUBE_COORDINATES_DATA_VALIDATOR_MOCK,
            POINT_PARSER_MOCK, CUBE_VALIDATOR_MOCK,EDGE_CALCULATOR_MOCK);

    @Test
    public void testCreateCubesShouldReturnListWithThreeOneCubeWhenGivenLineArePointsOfCubes() throws DataParserException {
        //given
        List<String> correctLines = Collections.singletonList("0 0 0 1 0 0 1 0 1 0 0 1 0 1 0 1 1 0 1 1 1 0 1 1");
        List<Point> pointList = Arrays.asList(
                new Point(0, 0, 0),
                new Point(1, 0, 0),
                new Point(1, 0, 1),
                new Point(0, 0, 1),
                new Point(0, 1, 0),
                new Point(1, 1, 0),
                new Point(1, 1, 1),
                new Point(0, 1, 1)
        );
        double expectedEdge = 1d;
        List<Cube> expectedListWithCube = Collections.singletonList(new Cube(pointList, expectedEdge));

        when(CUBE_COORDINATES_DATA_VALIDATOR_MOCK.validate(anyString())).thenReturn(true);
        when(POINT_PARSER_MOCK.parse(anyString())).thenReturn(pointList);
        when(CUBE_VALIDATOR_MOCK.validateCube(pointList)).thenReturn(true);
        when(EDGE_CALCULATOR_MOCK.getEdge(pointList)).thenReturn(1d);

        //when
        List<Cube> cubesResult = CUBE_CREATOR.createCubes(correctLines);
        //then
        Assertions.assertEquals(expectedListWithCube, cubesResult);
    }

    @Test
    public void testCreateCubesShouldReturnListWithZeroCubesWhenGivenLinesAreNotPointsOfCubes() throws DataParserException {
        //given
        int expectedSize = 0;
        List<String> incorrectLines = Arrays.asList(
                "0d 0 0 1 0 0 1 0 1 0 0 1 0 1 0 1 1 0 1 1 1 0 1 1",
                "0 0 0 1 0 0 1 0 1 0 0 1 0 1 0 1 1 0 1 1 1 0 1 16",
                "0 0 0 1 0 0 1 0 1 0d 0 1 0 1 0 1 1 0 1 1 1 0 1 1");
        when(CUBE_COORDINATES_DATA_VALIDATOR_MOCK.validate(anyString())).thenReturn(false);

        //when
        List<Cube> cubesResult = CUBE_CREATOR.createCubes(incorrectLines);
        //then
        Assertions.assertEquals(expectedSize, cubesResult.size());
    }


}
