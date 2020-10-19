package com.github.gkttk.seventh.cubecalculator.logic.observer.converter;

/**
 * This class generates id for CubeObservable.
 */
public class CubeObservableIdGenerator {

    private int idForCube;

    public int getCubeId() {
        return ++idForCube;
    }
}
