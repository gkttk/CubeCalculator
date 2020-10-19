package com.github.gkttk.seventh.cubecalculator.logic.observer;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

public class CubeObservableTest {

    private final static CubeObserver CUBE_OBSERVER_MOCK = Mockito.mock(CubeObserver.class);
    private final static List<Point> CUBE_POINTS = Arrays.asList(
            new Point(1, 1, 1),
            new Point(1, 0, 0),
            new Point(0, 0, 0),
            new Point(1, 0, 1),
            new Point(0, 0, 1),
            new Point(0, 1, 0),
            new Point(1, 1, 0),
            new Point(0, 1, 1));
    private final static double EDGE = 1;
    private final static int ID = 1;
    private final static CubeObservable CUBE_OBSERVABLE = new CubeObservable(CUBE_POINTS, EDGE, ID);


    @Test
    public void testSetPointsShouldNotifyObserversWhenGetNewPoints() {
        //given
        CUBE_OBSERVABLE.addObserver(CUBE_OBSERVER_MOCK);
        List<Point> newPoints = Arrays.asList(
                new Point(10, 10, 10),
                new Point(10, 0, 0),
                new Point(0, 0, 0),
                new Point(10, 0, 10),
                new Point(0, 0, 10),
                new Point(0, 10, 0),
                new Point(10, 10, 0),
                new Point(0, 10, 10));
        //when
        CUBE_OBSERVABLE.setPoints(newPoints);
        //then
        verify(CUBE_OBSERVER_MOCK).notifyObserver(CUBE_OBSERVABLE);
    }


}
