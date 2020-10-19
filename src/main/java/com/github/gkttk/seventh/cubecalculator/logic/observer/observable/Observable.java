package com.github.gkttk.seventh.cubecalculator.logic.observer.observable;


import com.github.gkttk.seventh.cubecalculator.logic.observer.Observer;

/**
 * Common Observable interface.
 * Without removeObserver() and notifyAll() methods.
 */
public interface Observable {

    void addObserver(Observer observer);
}
