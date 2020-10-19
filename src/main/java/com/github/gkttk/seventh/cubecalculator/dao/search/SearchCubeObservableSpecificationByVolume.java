package com.github.gkttk.seventh.cubecalculator.dao.search;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.CubeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

/**
 * This specification find cubeObservables with volume between minVolume value and maxVolume value.
 */
public class SearchCubeObservableSpecificationByVolume implements SearchSpecification<CubeObservable> {

    private final CubeCalculator cubeCalculator;

    private final double minVolume;
    private final double maxVolume;


    public SearchCubeObservableSpecificationByVolume(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.cubeCalculator = new CubeCalculator();
    }

    //for test
    public SearchCubeObservableSpecificationByVolume(double minVolume, double maxVolume, CubeCalculator cubeCalculator) {
        this.cubeCalculator = cubeCalculator;
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(CubeObservable cubeObservable) {
        double cubeVolume = cubeCalculator.getCubeVolume(cubeObservable);

        int compareCurrentMin = Double.compare(cubeVolume, minVolume);
        int compareCurrentMax = Double.compare(cubeVolume, maxVolume);

        return (compareCurrentMin >= 0) && (compareCurrentMax <= 0);

    }
}
