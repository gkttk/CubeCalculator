package com.github.gkttk.seventh.cubecalculator.model;

import java.util.Objects;

public class Point {

    private final double xCoordinate;
    private final double yCoordinate;
    private final double zCoordinate;

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(point.xCoordinate, xCoordinate) == 0 &&
                Double.compare(point.yCoordinate, yCoordinate) == 0 &&
                Double.compare(point.zCoordinate, zCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, zCoordinate);
    }


    @Override
    public String toString() {
        return "Coordinates of point: x = " + xCoordinate + ", y = " + yCoordinate + ", z = " + zCoordinate;
    }
}
