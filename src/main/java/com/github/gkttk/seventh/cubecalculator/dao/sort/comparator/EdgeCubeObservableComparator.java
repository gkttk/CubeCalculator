package com.github.gkttk.seventh.cubecalculator.dao.sort.comparator;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

import java.util.Comparator;


/**
 * Comparator for sort by edge value.
 */
public class EdgeCubeObservableComparator implements Comparator<CubeObservable> {
    @Override
    public int compare(CubeObservable firstCubeObservable, CubeObservable secondCubeObservable) {
        double firstCubeObservableEdge = firstCubeObservable.getEdge();
        double secondCubeObservableEdge = secondCubeObservable.getEdge();
        return Double.compare(firstCubeObservableEdge, secondCubeObservableEdge);
    }
}
