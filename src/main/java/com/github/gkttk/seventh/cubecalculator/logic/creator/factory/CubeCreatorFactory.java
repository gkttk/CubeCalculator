package com.github.gkttk.seventh.cubecalculator.logic.creator.factory;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.EdgeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.creator.CubeCreator;
import com.github.gkttk.seventh.cubecalculator.logic.parser.DataParser;
import com.github.gkttk.seventh.cubecalculator.logic.parser.PointParser;
import com.github.gkttk.seventh.cubecalculator.logic.validator.cube.CubeValidator;
import com.github.gkttk.seventh.cubecalculator.logic.validator.data.CubeCoordinatesDataValidator;
import com.github.gkttk.seventh.cubecalculator.logic.validator.data.DataValidator;
import com.github.gkttk.seventh.cubecalculator.model.Point;

import java.util.List;

/**
 * Factory for CubeCreator.
 */
public class CubeCreatorFactory {

    private static final DataValidator CUBE_COORDINATES_DATA_VALIDATOR = new CubeCoordinatesDataValidator();
    private static final DataParser<List<Point>, String> POINT_PARSER = new PointParser();
    private static final CubeValidator CUBE_VALIDATOR = new CubeValidator();
    private static final EdgeCalculator EDGE_CALCULATOR = new EdgeCalculator();


    public CubeCreator createCubeCreator() {
        return new CubeCreator(CUBE_COORDINATES_DATA_VALIDATOR, POINT_PARSER, CUBE_VALIDATOR, EDGE_CALCULATOR);
    }
}
