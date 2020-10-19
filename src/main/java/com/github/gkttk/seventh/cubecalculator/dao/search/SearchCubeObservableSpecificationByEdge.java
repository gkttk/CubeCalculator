package com.github.gkttk.seventh.cubecalculator.dao.search;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

/**
 * This specification seek cubeObservable with given edge.
 */
public class SearchCubeObservableSpecificationByEdge implements SearchSpecification<CubeObservable> {

    private final double desiredEdge;

    public SearchCubeObservableSpecificationByEdge(double desiredEdge) {
        this.desiredEdge = desiredEdge;
    }

    @Override
    public boolean specified(CubeObservable cubeObservable) {
        double edge = cubeObservable.getEdge();
        return edge == desiredEdge;
    }
}
