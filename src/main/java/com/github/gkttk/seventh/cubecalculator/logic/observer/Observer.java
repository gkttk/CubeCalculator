package com.github.gkttk.seventh.cubecalculator.logic.observer;


import com.github.gkttk.seventh.cubecalculator.logic.observer.observable.CubeObservable;

/**
 * Common Observer interface
 */
public interface Observer {

    void notifyObserver(CubeObservable cubeObservable);
}
