package com.example.verhuurbedrijf;

public abstract class Venster implements ProductObserver {
    String medewerker;
    ProductInventaris productInventaris;
    public Venster(String medewerker, ProductInventaris productInventaris) {
        this.medewerker = medewerker;
        this.productInventaris = productInventaris;
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

    public void sluitVenster(){
        System.out.println("");
    }

    @Override
    public void alsVeranderd(Product product) {
        System.out.println("\n" + product.getOmschrijving() + " is geweizigd");
        laadVenster();
    }
    public void alsToegevoegd(Product product) {
        System.out.println( "\n nieuw product toegevoegd: " + product.getOmschrijving());
        laadVenster();
    }
}
