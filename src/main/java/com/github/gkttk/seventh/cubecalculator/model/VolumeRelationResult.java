package com.github.gkttk.seventh.cubecalculator.model;

import java.util.Objects;

/**
 * This class is represents two volumes of shapes which built when a plane cut a cube.
 * firstVolume - volume of first shape.
 * secondVolume - volume of second shape.
 */
public class VolumeRelationResult {
    private final double firstVolume;
    private final double secondVolume;

    public VolumeRelationResult(double firstVolume, double secondVolume) {
        this.firstVolume = firstVolume;
        this.secondVolume = secondVolume;
    }


    public double getFirstVolume() {
        return firstVolume;
    }

    public double getSecondVolume() {
        return secondVolume;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolumeRelationResult that = (VolumeRelationResult) o;
        return Double.compare(that.firstVolume, firstVolume) == 0 &&
                Double.compare(that.secondVolume, secondVolume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstVolume, secondVolume);
    }


    @Override
    public String toString() {
        return "First shape volume: " + firstVolume + ". Second shape volume: " + secondVolume;
    }
}
