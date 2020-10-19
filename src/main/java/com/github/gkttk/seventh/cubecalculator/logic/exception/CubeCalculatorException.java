package com.github.gkttk.seventh.cubecalculator.logic.exception;

import com.github.gkttk.seventh.cubecalculator.model.plane.AbstractParallelPlane;

/**
 * This exception throws when a parallel plane does not cut a cube.
 */
public class CubeCalculatorException extends Exception {

    public CubeCalculatorException(String message, AbstractParallelPlane plane) {
        super(message);
        System.out.println(plane.toString());
    }
}
