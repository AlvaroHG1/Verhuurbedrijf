package com.example.verhuurbedrijf;

public abstract class Venster implements ProductObserver {
    String medewerker;

    public Venster(String medewerker) {
        this.medewerker = medewerker;
    }

    public void openVenster(){
        toonMedewerker();
        laadVenster();
        sluitVenster();
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
        System.out.println(product.getOmschrijving() + "is veranderd");
        laadVenster();
    }
}