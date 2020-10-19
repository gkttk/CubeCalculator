package com.github.gkttk.seventh.cubecalculator.logic.observer.observable;

import com.github.gkttk.seventh.cubecalculator.logic.calculator.EdgeCalculator;
import com.github.gkttk.seventh.cubecalculator.logic.observer.Observer;
import com.github.gkttk.seventh.cubecalculator.model.Cube;
import com.github.gkttk.seventh.cubecalculator.model.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Observable cube with new Id field. It uses edgeCalculator for calculate edge when getting new points.
 * New points are not validated.
 */
public class CubeObservable extends Cube implements Observable {

    private final int id;
    private final Set<Observer> observers;
    private final EdgeCalculator edgeCalculator;

    public CubeObservable(List<Point> points, double edge, int id) {
        super(points, edge);
        this.id = id;
        this.edgeCalculator = new EdgeCalculator();
        this.observers = new HashSet<>();
    }

    //for test
    public CubeObservable(List<Point> points, double edge, int id, EdgeCalculator edgeCalculator) {
        super(points, edge);
        this.id = id;
        this.edgeCalculator = edgeCalculator;
        this.observers = new HashSet<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    public void setPoints(List<Point> points) {
        super.setPoints(points);
        double newEdge = edgeCalculator.getEdge(points);
        super.setEdge(newEdge);
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.notifyObserver(this);
        }
    }

    public int getId() {
        return id;
    }

    public List<Point> getPoints() {
        return super.getPoints();
    }

    public double getEdge() {
        return super.getEdge();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CubeObservable that = (CubeObservable) o;
        return id == that.id &&
                Objects.equals(observers, that.observers) &&
                Objects.equals(edgeCalculator, that.edgeCalculator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, observers, edgeCalculator);
    }
}
