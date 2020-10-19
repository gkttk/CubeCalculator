package com.github.gkttk.seventh.cubecalculator.logic.creator;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.EdgeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.exception.DataParserException;
import com.github.gkttk.seventh.cubecalculator.logic.parser.DataParser;
import com.github.gkttk.seventh.cubecalculator.logic.validator.cube.CubeValidator;
import com.github.gkttk.seventh.cubecalculator.logic.validator.data.DataValidator;
import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;

import java.util.ArrayList;
import java.util.List;

public class CubeCreator {

    private final DataValidator cubeCoordinatesDataValidator;
    private final DataParser<List<Point>, String> pointParser;
    private final CubeValidator cubeValidator;
    private final EdgeCalculator edgeCalculator;

    public CubeCreator(DataValidator cubeCoordinatesDataValidator, DataParser<List<Point>, String> pointParser,
                       CubeValidator cubeValidator, EdgeCalculator edgeCalculator) {
        this.cubeCoordinatesDataValidator = cubeCoordinatesDataValidator;
        this.pointParser = pointParser;
        this.cubeValidator = cubeValidator;
        this.edgeCalculator = edgeCalculator;
    }

    /**
     * This method creates list of cubes from given list of strings.
     *
     * @return value can be empty list.
     */
    public List<Cube> createCubes(List<String> lines) throws DataParserException {
        List<Cube> cubes = new ArrayList<>();
        for (String line : lines) {
            if (isLineValid(line)) {
                List<Point> points = pointParser.parse(line);
                if (isThisCube(points)) {
                    double edgeForCube = edgeCalculator.getEdge(points);
                    Cube cube = new Cube(points, edgeForCube);
                    cubes.add(cube);
                }
            }
        }
        return cubes;
    }

    /**
     * This method validates a single line.
     * Private method using in createCubes();
     */
    private boolean isLineValid(String line) {
        return cubeCoordinatesDataValidator.validate(line);
    }

    /**
     * This method validates a list of points to building a single cube.
     * Private method using in createCubes();
     */
    private boolean isThisCube(List<Point> points) {
        return cubeValidator.validateCube(points);
    }


}
