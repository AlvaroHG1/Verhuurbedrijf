package com.example.verhuurbedrijf;

import java.util.ArrayList;
import java.util.List;

public abstract class Product implements Observable {
    String omschrijving;
    boolean verhuurd = false;
    HuurContract contract;
    public ArrayList<ProductObserver> observers;

    public Product(String omschrijving) {
        this.omschrijving = omschrijving;
        observers = new ArrayList<>();
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public abstract String toonDetails();
    public void setContract(HuurContract contract) {this.contract = contract;}
    public String getOmschrijving() {
        return omschrijving;
    }
    public HuurContract getContract() {return contract;}
    public void setVerhuurd(boolean verhuurd) {this.verhuurd = verhuurd;}
    public boolean isVerhuurd() {
        return verhuurd;
    }

    public void voegObserverToe(ProductObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Product product) {
        for (ProductObserver observer : observers) {
            observer.alsVeranderd(product);
        }
    }

    public void verhuurProduct(String verhuurder, String klantNaam) {
        if (!verhuurd) {
            HuurContract contract = new HuurContract(verhuurder, klantNaam);
            contract.verhuur(this);
        } else {
            System.out.println("Het product is al verhuurd.");
        }
    }

    public void retourProduct() {
        if (verhuurd) {
            this.verhuurd = false;
            this.contract = null;
            System.out.println("Het product is retour genomen.");
            notifyObservers(this);
        } else {
            System.out.println("Het product is niet verhuurd.");
        }
    }
}
