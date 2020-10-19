package com.github.gkttk.seventh.cubecalculator.dao;

import com.github.gkttk.seventh.cubecalculator.dao.search.SearchSpecification;
import com.github.gkttk.seventh.cubecalculator.dao.sort.AbstractSortSpecification;

import java.util.List;

/**
 * Common interface for repository
 */
public interface Repository<T> {

    void add(T object);
    List<T> findAll();
    void update(T object);
    void remove(T object);

    int count();

    List<T> query(SearchSpecification<T> specification);

    List<T> sort(AbstractSortSpecification<T> specification);




}
