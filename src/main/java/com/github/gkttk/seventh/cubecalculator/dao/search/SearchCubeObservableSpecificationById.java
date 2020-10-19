package com.github.gkttk.seventh.cubecalculator.dao.search;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

/**
 * This specification seek cubeObservable with given id.
 */
public class SearchCubeObservableSpecificationById implements SearchSpecification<CubeObservable> {

    private final int desiredId;

    public SearchCubeObservableSpecificationById(int desiredId) {
        this.desiredId = desiredId;
    }

    @Override
    public boolean specified(CubeObservable cubeObservable) {
        int cubeObservableId = cubeObservable.getId();
        return cubeObservableId == desiredId;
    }
}
