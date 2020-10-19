package com.github.gkttk.seventh.cubecalculator.logic.calculator.specification;

import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;

import java.util.List;

/**
 * Abstract specification for parallel planes.
 */
public abstract class ParallelPlaneSpecification {

    protected final Point point;

    public ParallelPlaneSpecification(Point point) {
        this.point = point;
    }

    /**
     * Method checks if current plane cuts given cube.
     */
    public boolean isCutCube(Cube cube) {
        double coordinateOfPlane = getCoordinate(this.point);
        double min = getMin(cube);
        double max = getMax(cube);

        return (min <= coordinateOfPlane && max >= coordinateOfPlane);
    }

    /**
     * Method provides a necessary coordinate of point, which represents current parallel plane.
     *
     * @return the coordinate depends on the heir
     */
    public abstract double getCoordinate(Point point);

    /**
     * Method seeks a min necessary coordinate value of given cube.
     */
    public double getMin(Cube cube) {
        List<Point> points = cube.getPoints();
        Point firstPoint = points.get(0);
        double min = getCoordinate(firstPoint);
        for (Point point : points) {
            double current = getCoordinate(point);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    /**
     * Method seeks a max necessary coordinate value of given cube.
     */
    public double getMax(Cube cube) {
        List<Point> points = cube.getPoints();
        Point firstPoint = points.get(0);
        double max = getCoordinate(firstPoint);
        for (Point point : points) {
            double current = getCoordinate(point);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

}
