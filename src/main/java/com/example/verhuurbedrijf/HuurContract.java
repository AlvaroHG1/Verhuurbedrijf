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
        product.setVerhuurd(true);
        System.out.println("Het product is verhuurd aan " + klantNaam + ".");
        product.notifyObservers(product);
    }

    public String getKlantNaam() {
        return klantNaam;
    }

    public String getVerhuurder() {
        return verhuurder;
    }
}
