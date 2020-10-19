package com.github.gkttk.seventh.cubecalculator.model.plane;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.specification.ParallelPlaneSpecification;
import com.github.gkttk.seventh.cubecalculator.logic.calculator.specification.XSpecification;
import com.github.gkttk.seventh.cubecalculator.model.Point;

/**
 * Y - 0 - Z parallel plane.
 */
public class YZParallelPlane extends AbstractParallelPlane {

    public YZParallelPlane(Point point) {
        super(point);
    }

    @Override
    public ParallelPlaneSpecification getSpecification() {
        return new XSpecification(this.point);
    }

    @Override
    public String toString() {
        double xCoordinate = point.getXCoordinate();
        double yCoordinate = point.getYCoordinate();
        double zCoordinate = point.getZCoordinate();
        return "Plane: YZ, CoordinateX = " + xCoordinate + ", CoordinateY = " + yCoordinate + ", CoordinateZ = " + zCoordinate;
    }

}
