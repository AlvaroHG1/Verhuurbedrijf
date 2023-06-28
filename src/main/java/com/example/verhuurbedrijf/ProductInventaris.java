package com.example.verhuurbedrijf;

import java.util.ArrayList;
public class ProductInventaris implements ProductObserver{
    private static ArrayList<Product> producten;
    private ArrayList<ProductObserver> vensters;

    public ProductInventaris() {
        producten = new ArrayList<>();
        vensters = new ArrayList<>();
    }

    public void addProduct(Product product) {
        product.voegObserverToe(this);
        producten.add(product);
        notifyObservers(product);
    }

    public Product getProduct(int getal){
        return producten.get(getal);
    }
    public ArrayList<Product> getProducten() {
        return producten;
    }

    public void voegObserverToe(ProductObserver observer) {
        vensters.add(observer);
    }

    public void notifyObservers(Product product){
            for (ProductObserver venster : vensters) {
                venster.alsToegevoegd(product);
            }
    }

    public void alsVeranderd(Product product) {
        for (ProductObserver venster : vensters) {
            venster.alsVeranderd(product);
        }
    }

    public void alsToegevoegd(Product product) {

    }
}

