package com.github.gkttk.seventh.cubecalculator.model.plane;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.specification.ParallelPlaneSpecification;
import com.github.gkttk.seventh.cubecalculator.model.Point;

/**
 * An abstract parallel plane.
 */
public abstract class AbstractParallelPlane {

    protected final Point point;

    public AbstractParallelPlane(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }


    /**
     * This method provides a specification which depends on specific parallel plane.
     * Template method.
     */
    public abstract ParallelPlaneSpecification getSpecification();


}
