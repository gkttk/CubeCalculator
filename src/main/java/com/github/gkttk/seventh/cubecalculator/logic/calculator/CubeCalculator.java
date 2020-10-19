package com.github.gkttk.seventh.cubecalculator.logic.calculator;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.enums.CoordinateName;
import com.github.gkttk.seventh.cubecalculator.logic.calculator.specification.ParallelPlaneSpecification;
import com.github.gkttk.seventh.cubecalculator.logic.exception.CubeCalculatorException;
import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import com.github.gkttk.seventh.cubecalculator.model.VolumeRelationResult;
import com.github.gkttk.seventh.cubecalculator.model.plane.AbstractParallelPlane;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CubeCalculator {

    private static final Logger LOGGER = LogManager.getLogger(CubeCalculator.class);

    /**
     * Method calculates volumes of 2 shapes, received by cutting of given cube by given plane.
     *
     * @return VolumeRelationResult object which represents two volumes of shapes.
     * @throws CubeCalculatorException throws if given plane does not cut given cube.
     */
    public VolumeRelationResult getVolumeRelations(AbstractParallelPlane plane, Cube cube) throws CubeCalculatorException {
        ParallelPlaneSpecification specification = plane.getSpecification();
        if (specification.isCutCube(cube)) {
            Point point = plane.getPoint();
            double coordinate = specification.getCoordinate(point);

            double min = specification.getMin(cube);
            double max = specification.getMax(cube);

            double firstShapeHeight = coordinate - min;
            double secondShapeHeight = max - coordinate;

            double edge = cube.getEdge();

            double firstVolume = edge * edge * firstShapeHeight;
            double secondVolume = edge * edge * secondShapeHeight;

            return new VolumeRelationResult(firstVolume, secondVolume);
        } else {
            throw new CubeCalculatorException("Given plane does not cut given cube!", plane);
        }

    }


    /**
     * This method checks if given cube lying on one of coordinate plane.
     */
    public boolean isLyingOnCoordinatePlane(Cube cube) {

        Map<CoordinateName, Integer> countOfZeroValues = getCountsOfZeroValues(cube);

        for (Map.Entry<CoordinateName, Integer> entry : countOfZeroValues.entrySet()) {
            if (entry.getValue() >= 4) {
                LOGGER.log(Level.INFO, "Cube is lying on one of coordinate plane");
                return true;
            }
        }
        LOGGER.log(Level.INFO, "Cube is not lying on one of coordinate plane");
        return false;
    }


    /**
     * This method calculate number of zero values for every coordinate in given cube.
     * Private method using in isLyingOnCoordinatePlane();
     *
     * @return map with values CoordinateName(X, Y or Z) and number of zero values for the coordinate name.
     */
    private Map<CoordinateName, Integer> getCountsOfZeroValues(Cube cube) {
        List<Point> points = cube.getPoints();
        Map<CoordinateName, Integer> countOfZeroValues = new HashMap<>(3);
        countOfZeroValues.put(CoordinateName.X, 0);
        countOfZeroValues.put(CoordinateName.Y, 0);
        countOfZeroValues.put(CoordinateName.Z, 0);
        for (Point point : points) {
            if (point.getXCoordinate() == 0) {
                int currentValue = countOfZeroValues.get(CoordinateName.X);
                countOfZeroValues.put(CoordinateName.X, currentValue + 1);
            }
            if (point.getYCoordinate() == 0) {
                int currentValue = countOfZeroValues.get(CoordinateName.Y);
                countOfZeroValues.put(CoordinateName.Y, currentValue + 1);
            }
            if (point.getZCoordinate() == 0) {
                int currentValue = countOfZeroValues.get(CoordinateName.Z);
                countOfZeroValues.put(CoordinateName.Z, currentValue + 1);
            }
        }
        return countOfZeroValues;
    }


    /**
     * This method provides a surface area of given cube.
     */
    public double getCubeSurfaceArea(Cube cube) {
        double edge = cube.getEdge();
        return 4 * Math.pow(edge, 2);
    }

    /**
     * This method provides a volume of given cube.
     */
    public double getCubeVolume(Cube cube) {
        double edge = cube.getEdge();
        return Math.pow(edge, 3);
    }


}
