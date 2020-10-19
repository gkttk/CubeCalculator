package com.github.gkttk.seventh.cubecalculator.model.plane;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.specification.ParallelPlaneSpecification;
import com.github.gkttk.seventh.cubecalculator.logic.calculator.specification.YSpecification;
import com.github.gkttk.seventh.cubecalculator.model.Point;

/**
 * X - 0 - Z parallel plane.
 */
public class XZParallelPlane extends AbstractParallelPlane {

    public XZParallelPlane(Point point) {
        super(point);
    }

    @Override
    public ParallelPlaneSpecification getSpecification() {
        return new YSpecification(this.point);
    }

    @Override
    public String toString() {
        double xCoordinate = point.getXCoordinate();
        double yCoordinate = point.getYCoordinate();
        double zCoordinate = point.getZCoordinate();
        return "Plane: XZ, CoordinateX = " + xCoordinate + ", CoordinateY = " + yCoordinate + ", CoordinateZ = " + zCoordinate;
    }


}
