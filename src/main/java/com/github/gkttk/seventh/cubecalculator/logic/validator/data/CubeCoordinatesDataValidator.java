package com.github.gkttk.seventh.cubecalculator.logic.validator.data;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This validator checks a string for pattern matching.
 */
public class CubeCoordinatesDataValidator implements DataValidator {

    private static final String REGEX = "(-?\\d+(.\\d+)?\\s*){24}"; //on one line must be 24 numbers for cube
    private static final Logger LOGGER = LogManager.getLogger(CubeCoordinatesDataValidator.class);

    @Override
    public boolean validate(String line) {
        if (!line.matches(REGEX)) {
            LOGGER.log(Level.WARN, "Line is not valid:  " + line);
            return false;
        }
        return true;
    }

}
