package com.github.gkttk.seventh.cubecalculator.logic.observer.converter;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;
import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;

import java.util.List;

/**
 * This class converts Cube to CubeObservable.
 */
public class CubeObservableConverter {

    private final CubeObservableIdGenerator idGenerator;


    public CubeObservableConverter() {
        this.idGenerator = new CubeObservableIdGenerator();
    }

    //for test
    public CubeObservableConverter(CubeObservableIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public CubeObservable convertCube(Cube cube) {
        List<Point> points = cube.getPoints();
        double edge = cube.getEdge();
        int id = idGenerator.getCubeId();
        return new CubeObservable(points, edge, id);
    }

}
