package com.github.gkttk.seventh.cubecalculator.logic.calculator.specification;

import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import com.github.gkttk.seventh.cubecalculator.model.plane.AbstractParallelPlane;
import com.github.gkttk.seventh.cubecalculator.model.plane.XYParallelPlane;
import com.github.gkttk.seventh.cubecalculator.model.plane.XZParallelPlane;
import com.github.gkttk.seventh.cubecalculator.model.plane.YZParallelPlane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SpecificationTest {

    private static Cube cube;
    private final static Point POINT_FOR_CUTTING_PLANE = new Point(1.5, 1.5, 1.5);
    private final static Point POINT_FOR_NOT_CUTTING_PLANE = new Point(4, 4, 4);


    @BeforeAll
    static void init() {
        List<Point> cubePoints = Arrays.asList(
                new Point(0, 0, 0),
                new Point(3, 0, 0),
                new Point(3, 0, 3),
                new Point(0, 0, 3),
                new Point(0, 3, 0),
                new Point(3, 3, 0),
                new Point(3, 3, 3),
                new Point(0, 1, 3));
        double edgeForCube = 3d;
        cube = new Cube(cubePoints, edgeForCube);


    }


    @Test
    public void testIsCutCubeShouldReturnTrueIfGivenPlaneCutsGivenCube() {
        //given
        AbstractParallelPlane parallelXZPlane = new XZParallelPlane(POINT_FOR_CUTTING_PLANE);
        AbstractParallelPlane parallelXYPlane = new XYParallelPlane(POINT_FOR_CUTTING_PLANE);
        AbstractParallelPlane parallelYZPlane = new YZParallelPlane(POINT_FOR_CUTTING_PLANE);

        ParallelPlaneSpecification specificationForXZPlane = parallelXZPlane.getSpecification();
        ParallelPlaneSpecification specificationForXYPlane = parallelXYPlane.getSpecification();
        ParallelPlaneSpecification specificationForYZPlane = parallelYZPlane.getSpecification();
        //when
        boolean XYCutResult = specificationForXYPlane.isCutCube(cube);
        boolean XZCutResult = specificationForXZPlane.isCutCube(cube);
        boolean YZCutResult = specificationForYZPlane.isCutCube(cube);
        //then
        Assertions.assertTrue(XYCutResult);
        Assertions.assertTrue(XZCutResult);
        Assertions.assertTrue(YZCutResult);
    }

    @Test
    public void testIsCutCubeShouldReturnFalseIfGivenPlaneDoesNotCutsGivenCube() {
        //given
        AbstractParallelPlane parallelXZPlane = new XZParallelPlane(POINT_FOR_NOT_CUTTING_PLANE);
        AbstractParallelPlane parallelXYPlane = new XYParallelPlane(POINT_FOR_NOT_CUTTING_PLANE);
        AbstractParallelPlane parallelYZPlane = new YZParallelPlane(POINT_FOR_NOT_CUTTING_PLANE);

        ParallelPlaneSpecification specificationForXZPlane = parallelXZPlane.getSpecification();
        ParallelPlaneSpecification specificationForXYPlane = parallelXYPlane.getSpecification();
        ParallelPlaneSpecification specificationForYZPlane = parallelYZPlane.getSpecification();
        //when
        boolean XYCutResult = specificationForXYPlane.isCutCube(cube);
        boolean XZCutResult = specificationForXZPlane.isCutCube(cube);
        boolean YZCutResult = specificationForYZPlane.isCutCube(cube);
        //then
        Assertions.assertFalse(XYCutResult);
        Assertions.assertFalse(XZCutResult);
        Assertions.assertFalse(YZCutResult);
    }

    @Test
    public void testGetMinShouldReturnMinNecessaryValueOfCube() {
        //given
        AbstractParallelPlane parallelXZPlane = new XZParallelPlane(POINT_FOR_CUTTING_PLANE);
        AbstractParallelPlane parallelXYPlane = new XYParallelPlane(POINT_FOR_CUTTING_PLANE);
        AbstractParallelPlane parallelYZPlane = new YZParallelPlane(POINT_FOR_CUTTING_PLANE);

        ParallelPlaneSpecification specificationForXZPlane = parallelXZPlane.getSpecification();
        ParallelPlaneSpecification specificationForXYPlane = parallelXYPlane.getSpecification();
        ParallelPlaneSpecification specificationForYZPlane = parallelYZPlane.getSpecification();

        double expectedValue = 0;
        //when
        double XYGetMinResult = specificationForXYPlane.getMin(cube);
        double XZGetMinResult = specificationForXZPlane.getMin(cube);
        double YZGetMinResult = specificationForYZPlane.getMin(cube);
        //then
        Assertions.assertEquals(expectedValue, XYGetMinResult);
        Assertions.assertEquals(expectedValue, XZGetMinResult);
        Assertions.assertEquals(expectedValue, YZGetMinResult);
    }

    @Test
    public void testGetMaxShouldReturnMaxNecessaryValueOfCube() {
        //given
        AbstractParallelPlane parallelXZPlane = new XZParallelPlane(POINT_FOR_CUTTING_PLANE);
        AbstractParallelPlane parallelXYPlane = new XYParallelPlane(POINT_FOR_CUTTING_PLANE);
        AbstractParallelPlane parallelYZPlane = new YZParallelPlane(POINT_FOR_CUTTING_PLANE);

        ParallelPlaneSpecification specificationForXZPlane = parallelXZPlane.getSpecification();
        ParallelPlaneSpecification specificationForXYPlane = parallelXYPlane.getSpecification();
        ParallelPlaneSpecification specificationForYZPlane = parallelYZPlane.getSpecification();

        double expectedValue = 3;
        //when
        double XYGetMinResult = specificationForXYPlane.getMax(cube);
        double XZGetMinResult = specificationForXZPlane.getMax(cube);
        double YZGetMinResult = specificationForYZPlane.getMax(cube);
        //then
        Assertions.assertEquals(expectedValue, XYGetMinResult);
        Assertions.assertEquals(expectedValue, XZGetMinResult);
        Assertions.assertEquals(expectedValue, YZGetMinResult);
    }


}
