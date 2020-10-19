package com.github.gkttk.seventh.cubecalculator.logic.calculator.specification;

import com.github.gkttk.seventh.cubecalculator.model.Point;

/**
 * Specification for XZParallelPlane.
 */
public class YSpecification extends ParallelPlaneSpecification {


    public YSpecification(Point point) {
        super(point);
    }

    @Override
    public double getCoordinate(Point point) {
        return point.getYCoordinate();
    }


}
