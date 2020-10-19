package com.github.gkttk.seventh.cubecalculator.logic.observer;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;
import com.github.gkttk.seventh.cubecalculator.model.Parameters;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CubeObserverTest {

    private static final CubeObserver CUBE_OBSERVER = CubeObserver.getInstance();

    @Test
    public void testNotifyShouldAddInfoIntoCubeParametersMapWhenGetCubeObservable(){
        //given
        List<Point> points = Arrays.asList(
                new Point(3, 3, 3),
                new Point(3, 0, 0),
                new Point(0, 0, 0),
                new Point(3, 0, 3),
                new Point(0, 0, 3),
                new Point(0, 3, 0),
                new Point(3, 3, 0),
                new Point(0, 3, 3));
        double edge = 3;
        int id = 3;
        CubeObservable cubeObservable = new CubeObservable(points, edge, id);
        int expectedSize = 1;
        Parameters expectedParameters = new Parameters(27d, 36d);
        //when
        CUBE_OBSERVER.notifyObserver(cubeObservable);
        //then
        Map<Integer, Parameters> cubeParameters = CUBE_OBSERVER.getCubeParameters();
        int size = cubeParameters.size();
        Parameters parameters = cubeParameters.get(id);
        Assertions.assertEquals(expectedSize, size);
        Assertions.assertEquals(expectedParameters, parameters);
    }
}
