package com.github.gkttk.seventh.cubecalculator.logic.observer.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CubeObservableIdGeneratorTest {

    private final static CubeObservableIdGenerator CUBE_OBSERVABLE_ID_GENERATOR = new CubeObservableIdGenerator();

    @Test
    public void testGetCubeIdShouldIncrementNextId(){
        //given
        int expectedId = 2;
        int firstCallId = CUBE_OBSERVABLE_ID_GENERATOR.getCubeId();
        //when
        int secondCallId = CUBE_OBSERVABLE_ID_GENERATOR.getCubeId();
        //then
        Assertions.assertEquals(expectedId, secondCallId);
    }

}
