package com.github.gkttk.seventh.cubecalculator.dao.sort;

import com.github.gkttk.seventh.cubecalculator.dao.sort.comparator.YFirstPointCubeObservableComparator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

import java.util.Comparator;

/**
 * Specification for sort by y coordinate of first cube point.
 */
public class SortSpecificationByYFirstPoint extends AbstractSortSpecification<CubeObservable> {


    @Override
    protected Comparator<CubeObservable> getComparator() {
        return new YFirstPointCubeObservableComparator();
    }
}
