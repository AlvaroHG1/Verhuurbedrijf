package com.example.verhuurbedrijf.factorys;

import com.example.verhuurbedrijf.Product;
import com.example.verhuurbedrijf.ProductFactory;
import com.example.verhuurbedrijf.soorten.BoorMachine;
import com.example.verhuurbedrijf.soorten.PersonenAuto;

public class PersonenAutoFactory extends ProductFactory {
    String omschrijving;
    String merk;
    int gewicht;
    int motorInhoud;

    public PersonenAutoFactory(String omschrijving, String merk, int gewicht, int motorInhoud) {
        this.omschrijving = omschrijving;
        this.merk = merk;
        this.gewicht = gewicht;
        this.motorInhoud = motorInhoud;
    }

    @Override
    public PersonenAuto createProduct() {
        return new PersonenAuto(omschrijving, merk, gewicht, motorInhoud);
    }
}
