package com.github.gkttk.seventh.cubecalculator.logic.observer.converter;

import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;
import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;

public class CubeObservableConverterTest {

    private final static CubeObservableIdGenerator CUBE_OBSERVABLE_ID_GENERATOR_MOCK = Mockito.mock(CubeObservableIdGenerator.class);
    private final static CubeObservableConverter CUBE_OBSERVABLE_CONVERTER = new CubeObservableConverter(CUBE_OBSERVABLE_ID_GENERATOR_MOCK);


    @Test
    public void testConvertCubeShouldReturnNewCubeObservableWithCubeDataAndIdWhenGetCube(){
        //given
        when(CUBE_OBSERVABLE_ID_GENERATOR_MOCK.getCubeId()).thenReturn(5);
        List<Point> cubePoints = Arrays.asList(
                new Point(0, 0, 0),
                new Point(1, 0, 0),
                new Point(1, 0, 1),
                new Point(0, 0, 1),
                new Point(0, 1, 0),
                new Point(1, 1, 0),
                new Point(1, 1, 1),
                new Point(0, 1, 1)
        );
        double cubeEdge = 1d;
        int expectedId = 5;
        Cube cube = new Cube(cubePoints, cubeEdge);
        //when
        CubeObservable cubeObservable = CUBE_OBSERVABLE_CONVERTER.convertCube(cube);
        //then
        List<Point> cubeObservablePoints = cubeObservable.getPoints();
        double cubeObservableEdge = cubeObservable.getEdge();
        int cubeObservableId = cubeObservable.getId();


        Assertions.assertEquals(cubePoints, cubeObservablePoints);
        Assertions.assertEquals(cubeEdge, cubeObservableEdge);
        Assertions.assertEquals(expectedId, cubeObservableId);
    }

}
