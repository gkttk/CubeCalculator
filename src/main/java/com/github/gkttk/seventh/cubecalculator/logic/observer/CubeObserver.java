package com.github.gkttk.seventh.cubecalculator.logic.observer;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.CubeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;
import com.github.gkttk.seventh.cubecalculator.model.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Observer for Cube.
 * This class is Singleton.
 */
public class CubeObserver implements Observer {

    private static CubeObserver INSTANCE;
    private static final Logger LOGGER = LogManager.getLogger(CubeObserver.class);
    private final Map<Integer, Parameters> cubeParameters;
    private final CubeCalculator cubeCalculator;


    private CubeObserver() {
        this.cubeParameters = new HashMap<>();
        this.cubeCalculator = new CubeCalculator();
    }

    public static CubeObserver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CubeObserver();
        }
        return INSTANCE;
    }


    @Override
    public void notifyObserver(CubeObservable cubeObservable) {
        int cubeObservableId = cubeObservable.getId();
        Parameters parameters = getParametersForCube(cubeObservable);
        cubeParameters.put(cubeObservableId, parameters);
        LOGGER.info("Parameters for cube with id:{} was changed, new Parameters:{}",
                cubeObservableId, parameters);
    }

    /**
     * Private method calculates volume and surfaceArea for cubeObservable.
     */
    private Parameters getParametersForCube(CubeObservable cubeObservable) {
        double cubeVolume = cubeCalculator.getCubeVolume(cubeObservable);
        double cubeSurfaceArea = cubeCalculator.getCubeSurfaceArea(cubeObservable);
        return new Parameters(cubeVolume, cubeSurfaceArea);
    }

    /**
     * Method for checking values from the Observer.
     */
    public Map<Integer, Parameters> getCubeParameters() {
        return cubeParameters;
    }
}
