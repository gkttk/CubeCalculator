package com.github.gkttk.seventh.cubecalculator.logic.calculator;

import com.github.gkttk.seventh.cubecalculator.model.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has same methods as CubeValidator.
 * I separate this classes for single responsibility.
 */
public class EdgeCalculator {

    /**
     * This method is return a edge for cube from given points.
     * Here the method return a minimum distance from first point to others, which is edge of cube.
     * This method is not in CubeCalculator because it works with list of points, not with Cube.
     */
    public double getEdge(List<Point> points) {
        int indexOfFirstPoint = 0;
        List<Double> lengthsForPoint = getLengthsForPoint(indexOfFirstPoint, points);
        return getMinLineSegment(lengthsForPoint);
    }

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

    private double getLineSegmentLength(Point fistPoint, Point secondPoint) {
        double divineX = secondPoint.getXCoordinate() - fistPoint.getXCoordinate();
        double divineY = secondPoint.getYCoordinate() - fistPoint.getYCoordinate();
        double divineZ = secondPoint.getZCoordinate() - fistPoint.getZCoordinate();
        double squareOfDivineX = Math.pow(divineX, 2);
        double squareOfDivineY = Math.pow(divineY, 2);
        double squareOfDivineZ = Math.pow(divineZ, 2);

        return Math.sqrt(squareOfDivineX + squareOfDivineY + squareOfDivineZ);
    }

    private double getMinLineSegment(List<Double> lengths) {
        double minLineSegment = lengths.get(0);
        for (Double length : lengths) {
            if (length < minLineSegment) {
                minLineSegment = length;
            }
        }
        return minLineSegment;
    }


}
