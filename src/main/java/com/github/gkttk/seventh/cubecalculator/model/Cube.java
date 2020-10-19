package com.github.gkttk.seventh.cubecalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube {

    private List<Point> points;
    private double edge;

    public Cube(List<Point> points, double edge) {
        this.points = points;
        this.edge = edge;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cube cube = (Cube) o;
        return Double.compare(cube.edge, edge) == 0 &&
                Objects.equals(points, cube.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, edge);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cube:\n");
        for (Point point : points) {
            stringBuilder.append(point);
            stringBuilder.append("\n");
        }
        stringBuilder.append(edge);

        return stringBuilder.toString();
    }

    protected void setEdge(double edge) {
        this.edge = edge;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
