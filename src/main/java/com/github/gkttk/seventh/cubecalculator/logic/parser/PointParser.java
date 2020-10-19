package com.github.gkttk.seventh.cubecalculator.logic.parser;

import com.github.gkttk.seventh.cubecalculator.logic.exception.DataParserException;
import com.github.gkttk.seventh.cubecalculator.model.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * This parser parses string to list of points.
 */
public class PointParser implements DataParser<List<Point>, String> {

    private final static String REGEX_FOR_SPLIT = "\\s+";

    /**
     * @throws DataParserException can be thrown if this method parse() gets an incorrectly validated line.
     */
    @Override
    public List<Point> parse(String line) throws DataParserException {
        List<Point> points = new ArrayList<>();
        String[] words = line.split(REGEX_FOR_SPLIT);

        for (int i = 0; i < words.length; i++) {
            String xString = words[i];
            String yString = words[++i];
            String zString = words[++i];
            try {
                Point point = getPoint(xString, yString, zString);
                points.add(point);
            } catch (NumberFormatException exception) {
                throw new DataParserException("Can't parse a value!", exception);
            }
        }
        return points;
    }

    /**
     * This method collects a point from three strings.
     * Private method using in parse();
     */
    private Point getPoint(String xString, String yString, String zString) {
        double xCoordinate = Double.parseDouble(xString);
        double yCoordinate = Double.parseDouble(yString);
        double zCoordinate = Double.parseDouble(zString);
        return new Point(xCoordinate, yCoordinate, zCoordinate);


    }
}
