package com.github.gkttk.seventh.cubecalculator.dao;

import com.github.gkttk.seventh.cubecalculator.dao.search.SearchSpecification;
import com.github.gkttk.seventh.cubecalculator.dao.sort.AbstractSortSpecification;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository for CubeObservable entity.
 */
public class CubeObservableRepository implements Repository<CubeObservable> {

    private final List<CubeObservable> repository;

    public CubeObservableRepository() {
        repository = new ArrayList<>();
    }

    @Override
    public void add(CubeObservable cubeObservable) {
        repository.add(cubeObservable);
    }

    @Override
    public void remove(CubeObservable cubeObservable) {
        repository.remove(cubeObservable);
    }

    /**
     * @return copy of repository list.
     */
    @Override
    public List<CubeObservable> findAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public int count() {
        return repository.size();
    }


    @Override
    public List<CubeObservable> query(SearchSpecification<CubeObservable> specification) {
        List<CubeObservable> result = new ArrayList<>();
        for (CubeObservable cubeObservable : repository) {
            if (specification.specified(cubeObservable)) {
                result.add(cubeObservable);
            }
        }
        return result;
    }

    @Override
    public List<CubeObservable> sort(AbstractSortSpecification<CubeObservable> specification) {
        return specification.sort(this);
    }

    @Override
    public void update(CubeObservable cubeObservable) {
        int cubeId = cubeObservable.getId();
        for (int i = 0; i < repository.size(); i++) {
            CubeObservable currentCube = repository.get(i);
            int currentCubeId = currentCube.getId();
            if (currentCubeId == cubeId) {
                remove(currentCube);
                add(cubeObservable);
                break;
            }
        }
    }


}
