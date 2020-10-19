package com.github.gkttk.seventh.cubecalculator.dao.sort.comparator;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;
import com.github.gkttk.seventh.cubecalculator.model.Point;

import java.util.Comparator;
import java.util.List;

/**
 * Comparator for sort by y coordinate of first cube point.
 */
public class YFirstPointCubeObservableComparator implements Comparator<CubeObservable> {
    @Override
    public int compare(CubeObservable firstCubeObservable, CubeObservable secondCubeObservable) {
        List<Point> firstCubeObservablePoints = firstCubeObservable.getPoints();
        List<Point> secondCubeObservablePoints = secondCubeObservable.getPoints();

        Point firstCubePoint = firstCubeObservablePoints.get(0);
        Point secondCubePoint = secondCubeObservablePoints.get(0);

        double firstYCoordinate = firstCubePoint.getYCoordinate();
        double secondYCoordinate = secondCubePoint.getYCoordinate();

        return Double.compare(firstYCoordinate, secondYCoordinate);
    }
}
