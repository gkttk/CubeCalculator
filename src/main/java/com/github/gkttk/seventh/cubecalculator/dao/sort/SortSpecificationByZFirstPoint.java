package com.github.gkttk.seventh.cubecalculator.dao.sort;

import com.github.gkttk.seventh.cubecalculator.dao.sort.comparator.ZFirstPointCubeObservableComparator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

import java.util.Comparator;

/**
 * Specification for sort by z coordinate of first cube point.
 */
public class SortSpecificationByZFirstPoint extends AbstractSortSpecification<CubeObservable> {


    @Override
    protected Comparator<CubeObservable> getComparator() {
        return new ZFirstPointCubeObservableComparator();
    }
}
