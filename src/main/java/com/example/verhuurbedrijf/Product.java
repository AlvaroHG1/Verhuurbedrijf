package com.example.verhuurbedrijf;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class Product{
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
    public void addObserver(ProductObserver observer) {
        observers.add(observer);
    }
    private void notifyObservers() {
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
