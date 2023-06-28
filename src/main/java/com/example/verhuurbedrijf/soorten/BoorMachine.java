package com.example.verhuurbedrijf.soorten;

import com.example.verhuurbedrijf.Product;

public class BoorMachine extends Product {
    String merk;
    String type;

    public BoorMachine(String omschrijving, String merk, String type) {
        super(omschrijving);
        this.merk = merk;
        this.type = type;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toonDetails() {
        return " Merk: "+ merk + " Type: " + type;
    }
}
