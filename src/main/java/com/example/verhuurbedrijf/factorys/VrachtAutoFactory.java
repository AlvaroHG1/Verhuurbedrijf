package com.example.verhuurbedrijf.factorys;

import com.example.verhuurbedrijf.Product;
import com.example.verhuurbedrijf.ProductFactory;
import com.example.verhuurbedrijf.soorten.VrachtAuto;

public class VrachtAutoFactory extends ProductFactory {
    String omschrijving;
    int laadVermogen;
    int motorInhoud;

    public VrachtAutoFactory(String omschrijving, int laadVermogen, int motorInhoud) {
        this.omschrijving = omschrijving;
        this.laadVermogen = laadVermogen;
        this.motorInhoud = motorInhoud;
    }
    @Override
    public VrachtAuto createProduct() {
        return new VrachtAuto(omschrijving, laadVermogen, motorInhoud);
    }
}
