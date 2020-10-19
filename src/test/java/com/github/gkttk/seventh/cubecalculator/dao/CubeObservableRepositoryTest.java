package com.github.gkttk.seventh.cubecalculator.dao;

import com.github.gkttk.seventh.cubecalculator.dao.search.*;
import com.github.gkttk.seventh.cubecalculator.dao.sort.*;
import com.github.gkttk.seventh.cubecalculator.logic.calculator.CubeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.calculator.EdgeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;
import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class CubeObservableRepositoryTest {

    private final static EdgeCalculator EDGE_CALCULATOR_MOCK = Mockito.mock(EdgeCalculator.class);
    private final static CubeCalculator CUBE_CALCULATOR_MOCK = Mockito.mock(CubeCalculator.class);

    private final static List<Point> FIRST_CUBE_POINTS = Arrays.asList(
            new Point(3, 3, 3),
            new Point(3, 0, 0),
            new Point(0, 0, 0),
            new Point(3, 0, 3),
            new Point(0, 0, 3),
            new Point(0, 3, 0),
            new Point(3, 3, 0),
            new Point(0, 1, 3));
    private final static double FIRST_EDGE = 3;
    private final static List<Point> SECOND_CUBE_POINTS = Arrays.asList(
            new Point(1, 1, 1),
            new Point(1, 0, 0),
            new Point(0, 0, 0),
            new Point(1, 0, 1),
            new Point(0, 0, 1),
            new Point(0, 1, 0),
            new Point(1, 1, 0),
            new Point(0, 1, 1));
    private final static double SECOND_EDGE = 1;
    private final static List<Point> THIRD_CUBE_POINTS = Arrays.asList(
            new Point(2, 2, 2),
            new Point(2, 0, 0),
            new Point(0, 0, 0),
            new Point(2, 0, 2),
            new Point(0, 0, 2),
            new Point(0, 2, 0),
            new Point(2, 2, 0),
            new Point(0, 2, 2));
    private final static double THIRD_EDGE = 2;


    private final static CubeObservable FIRST_CUBE_OBSERVABLE = new CubeObservable(FIRST_CUBE_POINTS, FIRST_EDGE, 1, EDGE_CALCULATOR_MOCK);
    private final static CubeObservable SECOND_CUBE_OBSERVABLE = new CubeObservable(SECOND_CUBE_POINTS, SECOND_EDGE, 2, EDGE_CALCULATOR_MOCK);
    private final static CubeObservable THIRD_CUBE_OBSERVABLE = new CubeObservable(THIRD_CUBE_POINTS, THIRD_EDGE, 3, EDGE_CALCULATOR_MOCK);

    private static Repository<CubeObservable> cubeObservableRepository;


    @BeforeEach
    public void beforeEach() {
        cubeObservableRepository = new CubeObservableRepository();
        cubeObservableRepository.add(FIRST_CUBE_OBSERVABLE);
        cubeObservableRepository.add(SECOND_CUBE_OBSERVABLE);
        cubeObservableRepository.add(THIRD_CUBE_OBSERVABLE);
    }

    @Test
    public void testAddShouldAddEntityIntoRepository() {
        //given
        int expectedSize = 4;
        //when
        cubeObservableRepository.add(FIRST_CUBE_OBSERVABLE);
        //then
        Assertions.assertEquals(expectedSize, cubeObservableRepository.count());
    }

    @Test
    public void testRemoveShouldRemoveEntityFromRepository() {
        //given
        int expectedSize = 2;
        //when
        cubeObservableRepository.remove(FIRST_CUBE_OBSERVABLE);
        //then
        Assertions.assertEquals(expectedSize, cubeObservableRepository.count());
    }

    @Test
    public void testFindAllShouldReturnCopyOfRepository() {
        //given
        int expectedSize = 3;
        //when
        cubeObservableRepository.findAll();
        //then
        Assertions.assertEquals(expectedSize, cubeObservableRepository.count());
    }

    @Test
    public void testQueryShouldReturnTwoEntityWithPropertyId() {
        //given
        int expectedSize = 1;
        int desiredId = 1;
        SearchSpecification<CubeObservable> searchSpecification = new SearchCubeObservableSpecificationById(desiredId);
        //when
        List<CubeObservable> cubesWithDesiredId = cubeObservableRepository.query(searchSpecification);
        //then
        Assertions.assertEquals(expectedSize, cubesWithDesiredId.size());
    }

    @Test
    public void testQueryShouldReturnOneEntityWithPropertyEdge() {
        //given
        int expectedSize = 1;
        double desiredEdge = 1;
        SearchSpecification<CubeObservable> searchSpecification = new SearchCubeObservableSpecificationByEdge(desiredEdge);
        //when
        List<CubeObservable> cubesWithDesiredEdge = cubeObservableRepository.query(searchSpecification);
        //then
        Assertions.assertEquals(expectedSize, cubesWithDesiredEdge.size());
    }

    @Test
    public void testQueryShouldReturnOneEntityWithPropertyVolume() {
        //given
        int expectedSize = 1;
        double minDesiredVolume = 25;
        double maxDesiredVolume = 28;
        when(CUBE_CALCULATOR_MOCK.getCubeVolume(FIRST_CUBE_OBSERVABLE)).thenReturn(27d);
        when(CUBE_CALCULATOR_MOCK.getCubeVolume(SECOND_CUBE_OBSERVABLE)).thenReturn(1d);
        when(CUBE_CALCULATOR_MOCK.getCubeVolume(THIRD_CUBE_OBSERVABLE)).thenReturn(8d);
        SearchSpecification<CubeObservable> searchSpecification = new SearchCubeObservableSpecificationByVolume(minDesiredVolume, maxDesiredVolume);
        //when
        List<CubeObservable> cubesWithDesiredVolume = cubeObservableRepository.query(searchSpecification);
        //then
        Assertions.assertEquals(expectedSize, cubesWithDesiredVolume.size());
    }

    @Test
    public void testQueryShouldReturnOneEntityWithPropertySurfaceArea() {
        //given
        int expectedSize = 1;
        double minDesiredSurfaceArea = 2;
        double maxDesiredSurfaceArea = 5;
        when(CUBE_CALCULATOR_MOCK.getCubeSurfaceArea(FIRST_CUBE_OBSERVABLE)).thenReturn(36d);
        when(CUBE_CALCULATOR_MOCK.getCubeSurfaceArea(SECOND_CUBE_OBSERVABLE)).thenReturn(4d);
        when(CUBE_CALCULATOR_MOCK.getCubeSurfaceArea(THIRD_CUBE_OBSERVABLE)).thenReturn(16d);
        SearchSpecification<CubeObservable> searchSpecification = new SearchCubeObservableSpecificationBySurfaceArea(minDesiredSurfaceArea, maxDesiredSurfaceArea);
        //when
        List<CubeObservable> cubesWithDesiredSurfaceArea = cubeObservableRepository.query(searchSpecification);
        //then
        Assertions.assertEquals(expectedSize, cubesWithDesiredSurfaceArea.size());
    }

    @Test
    public void testSortShouldReturnCopyOfSortedRepositoryByEdgeWhenGetSortIdSpecification() {
        //given
        List<CubeObservable> expectedList = new ArrayList<>();
        expectedList.add(FIRST_CUBE_OBSERVABLE);
        expectedList.add(SECOND_CUBE_OBSERVABLE);
        expectedList.add(THIRD_CUBE_OBSERVABLE);
        AbstractSortSpecification<CubeObservable> sortSpecification = new SortSpecificationById();
        //when
        List<CubeObservable> sortedCubesById = cubeObservableRepository.sort(sortSpecification);
        //then
        Assertions.assertEquals(expectedList, sortedCubesById);
    }

    @Test
    public void testSortShouldReturnCopyOfSortedRepositoryByEdgeWhenGetSortEdgeSpecification() {
        //given
        List<CubeObservable> expectedList = new ArrayList<>();
        expectedList.add(SECOND_CUBE_OBSERVABLE);
        expectedList.add(THIRD_CUBE_OBSERVABLE);
        expectedList.add(FIRST_CUBE_OBSERVABLE);
        AbstractSortSpecification<CubeObservable> sortSpecification = new SortSpecificationByEdge();
        //when
        List<CubeObservable> sortedCubesById = cubeObservableRepository.sort(sortSpecification);
        //then
        Assertions.assertEquals(expectedList, sortedCubesById);
    }


    @Test
    public void testUpdateShouldUpdateSingleEntityInRepositoryWhenEntityExistsIntoRepository(){
        //given
        Repository<CubeObservable> testRepository = new CubeObservableRepository();
        testRepository.add(FIRST_CUBE_OBSERVABLE); //one entity
        List<Point> newPoints = Arrays.asList(
                new Point(12, 12, 12),
                new Point(12, 0, 0),
                new Point(0, 0, 0),
                new Point(12, 0, 12),
                new Point(0, 0, 12),
                new Point(0, 12, 0),
                new Point(12, 12, 0),
                new Point(0, 12, 12));
        double newEdge = 12;
        int currentId = FIRST_CUBE_OBSERVABLE.getId();
        CubeObservable expectedCubeObservable = new CubeObservable(newPoints, newEdge, currentId);
        //when
        testRepository.update(expectedCubeObservable);
        //then
        List<CubeObservable> listCubeObservables = testRepository.findAll(); //list with one entity
        CubeObservable cubeObservableFromRepository = listCubeObservables.get(0);
        Assertions.assertNotEquals(FIRST_CUBE_OBSERVABLE, cubeObservableFromRepository);
        Assertions.assertEquals(expectedCubeObservable, cubeObservableFromRepository);
    }

    @ParameterizedTest
    @MethodSource("sortSpecificationPointProvider")
    public void testSortShouldReturnCopyOfSortedRepositoryByEdgeWhenGetPropertyPointSpecification(AbstractSortSpecification<CubeObservable> sortSpecification) {
        //given
        List<CubeObservable> expectedList = new ArrayList<>();
        expectedList.add(SECOND_CUBE_OBSERVABLE);
        expectedList.add(THIRD_CUBE_OBSERVABLE);
        expectedList.add(FIRST_CUBE_OBSERVABLE);
        //when
        List<CubeObservable> sortedCubesById = cubeObservableRepository.sort(sortSpecification);
        //then
        Assertions.assertEquals(expectedList, sortedCubesById);
    }


    private static Object[][] sortSpecificationPointProvider() {
        return new Object[][]{
                {new SortSpecificationByXFirstPoint()},
                {new SortSpecificationByYFirstPoint()},
                {new SortSpecificationByZFirstPoint()}
        };
    }


}
