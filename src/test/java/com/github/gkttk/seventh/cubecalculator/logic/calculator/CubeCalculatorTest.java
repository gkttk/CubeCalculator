package com.github.gkttk.seventh.cubecalculator.logic.calculator;

import com.github.gkttk.seventh.cubecalculator.logic.exception.CubeCalculatorException;
import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import com.github.gkttk.seventh.cubecalculator.model.VolumeRelationResult;
import com.github.gkttk.seventh.cubecalculator.model.plane.AbstractParallelPlane;
import com.github.gkttk.seventh.cubecalculator.model.plane.XZParallelPlane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CubeCalculatorTest {

    private static final CubeCalculator CUBE_CALCULATOR = new CubeCalculator();
    private static Cube CUBE_ON_COORDINATE_PLANE;
    private static Cube CUBE_NOT_ON_COORDINATE_PLANE;


    @BeforeAll
    static void init() {
        List<Point> cubeOnCoordinatePlanePoints = Arrays.asList(
                new Point(0, 0, 0),
                new Point(2, 0, 0),
                new Point(2, 0, 2),
                new Point(0, 0, 2),
                new Point(0, 2, 0),
                new Point(2, 2, 0),
                new Point(2, 2, 2),
                new Point(0, 2, 2));
        double firstCubeEdge = 2d;
        CUBE_ON_COORDINATE_PLANE = new Cube(cubeOnCoordinatePlanePoints, firstCubeEdge);

        List<Point> cubeNotOnCoordinatePlanePoints = Arrays.asList(
                new Point(1, 1, 1),
                new Point(2, 1, 1),
                new Point(2, 1, 2),
                new Point(1, 1, 2),
                new Point(2, 1, 1),
                new Point(2, 2, 1),
                new Point(2, 2, 2),
                new Point(1, 2, 2));
        double secondCubeEdge = 1d;

        CUBE_NOT_ON_COORDINATE_PLANE = new Cube(cubeNotOnCoordinatePlanePoints, secondCubeEdge);

    }

    @Test
    public void testCalculateCubeVolumeShouldReturnCorrectVolumeOfGivenCube() {
        //given
        double expectedVolume = 8d;
        //when
        double resultVolume = CUBE_CALCULATOR.getCubeVolume(CUBE_ON_COORDINATE_PLANE);
        //then
        Assertions.assertEquals(expectedVolume, resultVolume);
    }

    @Test
    public void testCalculateCubeSurfaceAreaShouldReturnCorrectSurfaceArea() {
        //given
        double expectedVolume = 16d;
        //when
        double resultVolume = CUBE_CALCULATOR.getCubeSurfaceArea(CUBE_ON_COORDINATE_PLANE);
        //then
        Assertions.assertEquals(expectedVolume, resultVolume);
    }


    @Test
    public void testIsLyingOnCoordinatePlaneShouldReturnTrueWhenGivenCubeOnCoordinatePlane() {
        //given
        //when
        boolean resultIsLying = CUBE_CALCULATOR.isLyingOnCoordinatePlane(CUBE_ON_COORDINATE_PLANE);
        //then
        Assertions.assertTrue(resultIsLying);
    }

    @Test
    public void testIsLyingOnCoordinatePlaneShouldReturnFalseWhenGivenCubeIsNotOnCoordinatePlane() {
        //given
        //when
        boolean resultIsLying = CUBE_CALCULATOR.isLyingOnCoordinatePlane(CUBE_NOT_ON_COORDINATE_PLANE);
        //then
        Assertions.assertFalse(resultIsLying);
    }

    @Test
    public void testGetVolumeRelationsShouldReturnCorrectVolumeRelationsWhenGivenDataIsCorrect() throws CubeCalculatorException {
        //given
        Point pointForPlane = new Point(1, 1, 1);
        VolumeRelationResult expectedResult = new VolumeRelationResult(4d, 4d);
        AbstractParallelPlane plane = new XZParallelPlane(pointForPlane);
        //when
        VolumeRelationResult resultVolumeRelations = CUBE_CALCULATOR.getVolumeRelations(plane, CUBE_ON_COORDINATE_PLANE);
        //then
        Assertions.assertEquals(expectedResult, resultVolumeRelations);
    }

    @Test
    public void testGetVolumeRelationsShouldThrowExceptionWhenGivenPlaneDoesNotCutGivenCube() throws CubeCalculatorException {
        //given
        Point pointForPlane = new Point(1, 3, 1);
        AbstractParallelPlane plane = new XZParallelPlane(pointForPlane);
        //when
        //then
        Assertions.assertThrows(CubeCalculatorException.class, () -> CUBE_CALCULATOR.getVolumeRelations(plane, CUBE_ON_COORDINATE_PLANE));
    }


}
