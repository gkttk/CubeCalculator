package com.github.gkttk.seventh.cubecalculator.dao.sort;

import com.github.gkttk.seventh.cubecalculator.dao.Repository;

import java.util.Comparator;
import java.util.List;

/**
 * Abstract class for sort specifications.
 * Use abstract class here for using a template method which return specific comparator.
 */
public abstract class AbstractSortSpecification<T> {

    protected final Comparator<T> comparator;

    protected AbstractSortSpecification() {
        this.comparator = getComparator();
    }

    public List<T> sort(Repository<T> repository) {
        List<T> cubeObservables = repository.findAll();
        cubeObservables.sort(comparator);
        return cubeObservables;
    }

    /**
     * Template method
     */
    protected abstract Comparator<T> getComparator();

}
