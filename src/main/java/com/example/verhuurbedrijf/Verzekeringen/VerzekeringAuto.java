package com.example.verhuurbedrijf.Verzekeringen;

import com.example.verhuurbedrijf.Verzekering;

public class VerzekeringAuto extends Verzekering {
    public double berekenVerzekering(int motorInhoud) {
        return motorInhoud * 0.01;
    }

}
