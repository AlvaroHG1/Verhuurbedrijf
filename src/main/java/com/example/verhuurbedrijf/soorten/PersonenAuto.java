package com.example.verhuurbedrijf.soorten;

import com.example.verhuurbedrijf.Product;

public class PersonenAuto extends Product {
    String merk;
    int gewicht;
    int motorInhoud;

    public PersonenAuto(String omschrijving, String merk, int gewicht, int motorInhoud) {
        super(omschrijving);
        this.merk = merk;
        this.gewicht = gewicht;
        this.motorInhoud = motorInhoud;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public void setMotorInhoud(int motorInhoud) {
        this.motorInhoud = motorInhoud;
    }

    @Override
    public String toonDetails() {
        return " Merk: "+ merk + " Gewicht: " + gewicht + " Motorinhoud: " + motorInhoud;
    }
}
