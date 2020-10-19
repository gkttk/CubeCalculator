package com.github.gkttk.seventh.cubecalculator.dao.sort;

import com.github.gkttk.seventh.cubecalculator.dao.sort.comparator.IdCubeObservableComparator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

import java.util.Comparator;

/**
 * Specification for sort by id.
 */
public class SortSpecificationById extends AbstractSortSpecification<CubeObservable> {

    @Override
    protected Comparator<CubeObservable> getComparator() {
        return new IdCubeObservableComparator();
    }
}
