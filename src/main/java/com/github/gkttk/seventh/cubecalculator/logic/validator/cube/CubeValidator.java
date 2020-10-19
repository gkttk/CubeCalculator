package com.github.gkttk.seventh.cubecalculator.logic.validator.cube;

import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * This class validate list of points to build a cube.
 */
public class CubeValidator {

    private static final int EQUAL_CUBE_EDGES_COUNT = 3; //every point of cube has 3 identical minimal edges to other points
    private static final Logger LOGGER = LogManager.getLogger(CubeValidator.class);


    public boolean validateCube(List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            List<Double> lengthsForPoint = getLengthsForPoint(i, points);
            double minLineSegment = getMinLineSegment(lengthsForPoint);
            int countOfEqualsLineSegments = getNumberOfMinValues(minLineSegment, lengthsForPoint);
            if (countOfEqualsLineSegments != EQUAL_CUBE_EDGES_COUNT) {
                LOGGER.log(Level.WARN, "Can't build a cube with given points: {}", points);
                return false;
            }
        }
        return true;
    }


    /**
     * This method provides a list of lengths from one point to other points of the shape.
     * Private method using in validateCube() and getEdgeForCube().
     */
    private List<Double> getLengthsForPoint(int indexOfFromPoint, List<Point> points) {
        List<Double> lengths = new ArrayList<>();
        Point fromPoint = points.get(indexOfFromPoint);
        for (int i = 0; i < points.size(); i++) {
            if (i != indexOfFromPoint) {
                Point toPoint = points.get(i);
                double length = getLineSegmentLength(fromPoint, toPoint);
                lengths.add(length);
            }
        }
        return lengths;

    }

    /**
     * This method seeks a minimal value from list of lengths.
     * Private method using in validateCube() and getEdgeForCube().
     */
    private double getMinLineSegment(List<Double> lengths) {
        double minLineSegment = lengths.get(0);
        for (Double length : lengths) {
            if (length < minLineSegment) {
                minLineSegment = length;
            }
        }
        return minLineSegment;
    }

    /**
     * This method counts a number of min values from list of lengths;
     * Private method using in validateCube().
     */
    private int getNumberOfMinValues(double minLineSegment, List<Double> lengths) {
        int count = 0;
        for (Double length : lengths) {
            if (length == minLineSegment) {
                count++;
            }
        }
        return count;
    }


    /**
     * This method calculates a distance between two points.
     * Private method using in getLengthsForPoint().
     */
    private double getLineSegmentLength(Point fistPoint, Point secondPoint) {
        double divineX = secondPoint.getXCoordinate() - fistPoint.getXCoordinate();
        double divineY = secondPoint.getYCoordinate() - fistPoint.getYCoordinate();
        double divineZ = secondPoint.getZCoordinate() - fistPoint.getZCoordinate();
        double squareOfDivineX = Math.pow(divineX, 2);
        double squareOfDivineY = Math.pow(divineY, 2);
        double squareOfDivineZ = Math.pow(divineZ, 2);

        return Math.sqrt(squareOfDivineX + squareOfDivineY + squareOfDivineZ);
    }


}
