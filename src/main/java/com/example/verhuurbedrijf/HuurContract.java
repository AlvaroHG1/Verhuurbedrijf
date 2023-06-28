package com.example.verhuurbedrijf;
public class HuurContract {
    String verhuurder;
    String klantNaam;
    public HuurContract(String medewerker, String klantNaam) {

        this.verhuurder = medewerker;
        this.klantNaam = klantNaam;
    }

    public void verhuur(Product product) {
        product.setContract(this);
        System.out.println("Het product is verhuurd aan " + klantNaam + ".");
        product.notifyObservers();
    }

    public String getVerhuurder() {
        return verhuurder;
    }

    public void setVerhuurder(String verhuurder) {
        this.verhuurder = verhuurder;
    }

    public String getKlantNaam() {
        return klantNaam;
    }

    public void setKlantNaam(String klantNaam) {
        this.klantNaam = klantNaam;
    }

// Getters en setters voor verhuurder en klantNaam...
}
