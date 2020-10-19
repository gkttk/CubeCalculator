package com.github.gkttk.seventh.cubecalculator.model;

import java.util.Objects;

/**
 * Class with parameters of cube for Observer.
 */
public class Parameters {

    private final double cubeVolume;
    private final double cubeSurfaceArea;


    public Parameters(double cubeVolume, double cubeSurfaceArea) {
        this.cubeVolume = cubeVolume;
        this.cubeSurfaceArea = cubeSurfaceArea;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Parameters that = (Parameters) o;
        return Double.compare(that.cubeVolume, cubeVolume) == 0 &&
                Double.compare(that.cubeSurfaceArea, cubeSurfaceArea) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cubeVolume, cubeSurfaceArea);
    }

    @Override
    public String toString() {
        return "cubeVolume = " + cubeVolume + ", cubeSurfaceArea = " + cubeSurfaceArea;
    }
}
