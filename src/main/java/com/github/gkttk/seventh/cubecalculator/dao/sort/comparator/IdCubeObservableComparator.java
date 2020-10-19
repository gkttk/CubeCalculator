package com.github.gkttk.seventh.cubecalculator.dao.sort.comparator;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

import java.util.Comparator;

/**
 * Comparator for sort by id value.
 */
public class IdCubeObservableComparator implements Comparator<CubeObservable> {
    @Override
    public int compare(CubeObservable firstCubeObservable, CubeObservable secondCubeObservable) {
        int firstCubeObservableId = firstCubeObservable.getId();
        int secondCubeObservableId = secondCubeObservable.getId();
        return firstCubeObservableId - secondCubeObservableId;
    }
}
