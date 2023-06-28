package com.example.verhuurbedrijf;

import java.util.Scanner;

public abstract class Venster implements ProductObserver {
    String medewerker;
    ProductInventaris productInventaris;
    public Scanner scanner;

    public Venster(String medewerker, ProductInventaris productInventaris, Scanner scanner) {
        this.medewerker = medewerker;
        this.productInventaris = productInventaris;
        this.scanner = scanner;
    }

    public void openVenster(){
        toonMedewerker();
        laadVenster();
        sluitVenster();
    }

    public ProductInventaris getProductInventaris() {
        return productInventaris;
    }

    public String getMedewerker() {
        return medewerker;
    }

    public  void toonMedewerker(){
        System.out.println("Deze medewerker is ingelogd: " + medewerker);
    }
    public abstract void laadVenster();

    public abstract void sluitVenster();

    public void alsVeranderd(Product product) {
        System.out.println("\n" + product.getOmschrijving() + " is geweizigd");
        laadVenster();
    }
    public void alsToegevoegd(Product product) {
        System.out.println( "\n nieuw product toegevoegd: " + product.getOmschrijving());
        laadVenster();
    }
}
