package com.github.gkttk.seventh.cubecalculator.model.plane;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.specification.ParallelPlaneSpecification;
import com.github.gkttk.seventh.cubecalculator.logic.calculator.specification.ZSpecification;
import com.github.gkttk.seventh.cubecalculator.model.Point;

/**
 * X - 0 - Y parallel plane.
 */
public class XYParallelPlane extends AbstractParallelPlane {

    public XYParallelPlane(Point point) {
        super(point);
    }

    @Override
    public ParallelPlaneSpecification getSpecification() {
        return new ZSpecification(this.point);
    }


    @Override
    public String toString() {
        double xCoordinate = point.getXCoordinate();
        double yCoordinate = point.getYCoordinate();
        double zCoordinate = point.getZCoordinate();
        return "Plane: XY, CoordinateX = " + xCoordinate + ", CoordinateY = " + yCoordinate + ", CoordinateZ = " + zCoordinate;
    }
}
