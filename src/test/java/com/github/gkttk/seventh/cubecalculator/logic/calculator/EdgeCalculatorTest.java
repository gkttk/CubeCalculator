package com.github.gkttk.seventh.cubecalculator.logic.calculator;

import com.github.gkttk.seventh.cubecalculator.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class EdgeCalculatorTest {

    private final static EdgeCalculator EDGE_CALCULATOR = new EdgeCalculator();

    private final static List<Point> POINTS = Arrays.asList(
            new Point(3, 3, 3),
            new Point(3, 0, 0),
            new Point(0, 0, 0),
            new Point(3, 0, 3),
            new Point(0, 0, 3),
            new Point(0, 3, 0),
            new Point(3, 3, 0),
            new Point(0, 1, 3));

    @Test
    public void testGetEdgeShouldReturnOneWhenGetPoints() {
        //given
        double expectedEdge = 3d;
        //when
        double resultEdge = EDGE_CALCULATOR.getEdge(POINTS);
        //then
        Assertions.assertEquals(expectedEdge, resultEdge, 0.01);
    }
}
