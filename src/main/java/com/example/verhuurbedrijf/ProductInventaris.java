package com.example.verhuurbedrijf;

import java.util.ArrayList;

public class ProductInventaris implements ProductObserver {
    private ArrayList<Product> producten;
    private ArrayList<Venster> vensters;

    public ProductInventaris() {
        producten = new ArrayList<>();
        vensters = new ArrayList<>();
    }

    public void addProduct(Product product) {
        product.addObserver(this);
        producten.add(product);
    }
    public Product getProduct(int getal){
        return producten.get(getal);
    }
    public void addVenster(Venster venster) {
        vensters.add(venster);
    }

    public ArrayList<Product> getProducten() {
        return producten;
    }

    public void alsVeranderd(Product product) {
        for (Venster venster : vensters) {
            venster.alsVeranderd(product);
        }
    }
}
