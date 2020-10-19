package com.github.gkttk.seventh.cubecalculator.logic.calculator.specification;

import com.github.gkttk.seventh.cubecalculator.model.Point;

/**
 * Specification for XYParallelPlane.
 */
public class ZSpecification extends ParallelPlaneSpecification {

    public ZSpecification(Point point) {
        super(point);
    }

    @Override
    public double getCoordinate(Point point) {
        return point.getZCoordinate();
    }


}
