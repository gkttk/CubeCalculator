package com.github.gkttk.seventh.cubecalculator.dao.search;

/**
 * Common interface for SearchSpecification.
 */
public interface SearchSpecification<T> {

    boolean specified(T cubeObservable);

}
