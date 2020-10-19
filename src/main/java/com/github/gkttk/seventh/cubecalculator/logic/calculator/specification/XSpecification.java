package com.github.gkttk.seventh.cubecalculator.logic.calculator.specification;

import com.github.gkttk.seventh.cubecalculator.model.Point;

/**
 * Specification for YZParallelPlane.
 */
public class XSpecification extends ParallelPlaneSpecification {

    public XSpecification(Point point) {
        super(point);
    }

    @Override
    public double getCoordinate(Point point) {
        return point.getXCoordinate();
    }


}
