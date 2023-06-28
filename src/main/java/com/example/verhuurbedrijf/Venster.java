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
        clearVenster();
        toonMedewerker();
        laadVenster();
        sluitVenster();
    }

    private void clearVenster() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public ProductInventaris getProductInventaris() {
        return productInventaris;
    }

    public String getMedewerker() {
        return medewerker;
    }

    public  void toonMedewerker(){
        System.out.println("Ingelogd: " + medewerker+ "\n");
    }
    public abstract void laadVenster();
    public void alsVeranderd(Product product) {
        System.out.println("\n" + product.getOmschrijving() + " is geweizigd");
        laadVenster();
    }
    public void alsToegevoegd(Product product) {
        System.out.println( "\n nieuw product toegevoegd: " + product.getOmschrijving());
        laadVenster();
    }
    public abstract void sluitVenster();
}



