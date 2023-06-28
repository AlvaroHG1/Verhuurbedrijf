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


    @Override
    public PersonenAuto createProduct() {
        return new PersonenAuto(omschrijving, merk, gewicht, motorInhoud);
    }
}
