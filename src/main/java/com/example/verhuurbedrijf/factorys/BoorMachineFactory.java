package com.example.verhuurbedrijf.factorys;

import com.example.verhuurbedrijf.Product;
import com.example.verhuurbedrijf.ProductFactory;
import com.example.verhuurbedrijf.soorten.BoorMachine;

public class BoorMachineFactory extends ProductFactory {
    private String omschrijving;
    private String merk;
    private String type;


    @Override
    public BoorMachine createProduct() {
        return new BoorMachine(omschrijving, merk, type);
    }
}
