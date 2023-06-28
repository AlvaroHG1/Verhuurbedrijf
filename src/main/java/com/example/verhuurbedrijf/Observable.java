package com.example.verhuurbedrijf;

public interface Observable {

    void voegObserverToe(ProductObserver observer);

    void notifyObservers();
}
