package com.github.gkttk.seventh.cubecalculator.dao.sort;

import com.github.gkttk.seventh.cubecalculator.dao.sort.comparator.EdgeCubeObservableComparator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

import java.util.Comparator;

/**
 * Specification for sort by edge.
 */
public class SortSpecificationByEdge extends AbstractSortSpecification<CubeObservable> {


    @Override
    protected Comparator<CubeObservable> getComparator() {
        return new EdgeCubeObservableComparator();
    }
}
