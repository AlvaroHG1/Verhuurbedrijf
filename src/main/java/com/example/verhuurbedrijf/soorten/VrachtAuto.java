package com.example.verhuurbedrijf.soorten;

import com.example.verhuurbedrijf.Product;

public class VrachtAuto extends Product {
    int laadVermogen;
    int motorInhoud;

    public VrachtAuto(String omschrijving, int laadVermogen, int motorInhoud) {
        super(omschrijving);
        this.laadVermogen = laadVermogen;
        this.motorInhoud = motorInhoud;
    }

    public void setLaadVermogen(int laadVermogen) {
        this.laadVermogen = laadVermogen;
    }

    public void setMotorInhoud(int motorInhoud) {
        this.motorInhoud = motorInhoud;
    }

    @Override
    public String toonDetails() {
        return" Laadvermogen: "+ laadVermogen + " Motorinhoud: " + motorInhoud;
    }
}
