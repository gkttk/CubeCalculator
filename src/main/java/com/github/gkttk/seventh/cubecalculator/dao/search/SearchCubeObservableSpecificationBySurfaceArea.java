package com.github.gkttk.seventh.cubecalculator.dao.search;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.CubeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

/**
 * This specification find cubeObservables with surface area between minSurfaceArea value and maxSurfaceArea value.
 */
public class SearchCubeObservableSpecificationBySurfaceArea implements SearchSpecification<CubeObservable> {

    private final CubeCalculator cubeCalculator;

    private final double minSurfaceArea;
    private final double maxSurfaceArea;


    public SearchCubeObservableSpecificationBySurfaceArea(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
        this.cubeCalculator = new CubeCalculator();
    }

    //for test
    public SearchCubeObservableSpecificationBySurfaceArea(double minSurfaceArea, double maxSurfaceArea, CubeCalculator cubeCalculator) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
        this.cubeCalculator = cubeCalculator;
    }

    @Override
    public boolean specified(CubeObservable cubeObservable) {
        double cubeSurfaceArea = cubeCalculator.getCubeSurfaceArea(cubeObservable);

        int compareCurrentMin = Double.compare(cubeSurfaceArea, minSurfaceArea);
        int compareCurrentMax = Double.compare(cubeSurfaceArea, maxSurfaceArea);

        return (compareCurrentMin >= 0) && (compareCurrentMax <= 0);
    }


}
