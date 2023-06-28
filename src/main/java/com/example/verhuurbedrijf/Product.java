package com.example.verhuurbedrijf;

import java.util.ArrayList;
import java.util.List;

public abstract class Product implements Observable {
    String omschrijving;
    boolean verhuurd = false;
    String verhuurder;
    String klantNaam;
    public ArrayList<ProductObserver> observers;

    public Product(String omschrijving) {
        this.omschrijving = omschrijving;
        observers = new ArrayList<>();
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public abstract String toonDetails();

    public String getOmschrijving() {
        return omschrijving;
    }

    public boolean isVerhuurd() {
        return verhuurd;
    }

    public String getVerhuurder() {
        return verhuurder;
    }

    public String getKlantNaam() {
        return klantNaam;
    }
    public void voegObserverToe(ProductObserver observer) {
        observers.add(observer);
    }
    public void notifyObservers() {
        for (ProductObserver observer : observers) {
            observer.alsVeranderd(this);
        }
    }

    public void verhuurProduct(String verhuurder, String klantNaam) {
        if (!verhuurd) {
            this.verhuurd = true;
            this.verhuurder = verhuurder;
            this.klantNaam = klantNaam;
            System.out.println("Het product is verhuurd aan " + klantNaam + ".");
            notifyObservers();
        } else {
            System.out.println("Het product is al verhuurd.");
        }
    }

    public void retourProduct() {
        if (verhuurd) {
            this.verhuurd = false;
            this.verhuurder = null;
            this.klantNaam = null;
            System.out.println("Het product is retour genomen.");
            notifyObservers();
        } else {
            System.out.println("Het product is niet verhuurd.");
        }
    }
}
