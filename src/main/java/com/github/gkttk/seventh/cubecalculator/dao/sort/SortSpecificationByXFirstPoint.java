package com.github.gkttk.seventh.cubecalculator.dao.sort;

import com.github.gkttk.seventh.cubecalculator.dao.sort.comparator.XFirstPointCubeObservableComparator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

import java.util.Comparator;

/**
 * Specification for sort by x coordinate of first cube point.
 */
public class SortSpecificationByXFirstPoint extends AbstractSortSpecification<CubeObservable> {


    @Override
    protected Comparator<CubeObservable> getComparator() {
        return new XFirstPointCubeObservableComparator();
    }
}
