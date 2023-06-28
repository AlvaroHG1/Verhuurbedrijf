package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;
import java.util.Scanner;

public class Beheer extends Venster {

    public Beheer(String medewerker, ProductInventaris productInventaris) {
        super(medewerker, productInventaris);
    }

    @Override
    public void laadVenster() {
        System.out.println("Je bent in het beheer venster");
        getProductInventaris().voegObserverToe(this);
        toonBeheer();
    }

    public void toonBeheer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welk soort product wilt u toevoegen?");
        System.out.println("1. Boormachine");
        System.out.println("2. Personenauto");
        System.out.println("3. Vrachtauto");
        int input = scanner.nextInt();
        if (input == 1){
            Venster Toevoegen = new Toevoegen(getMedewerker(), getProductInventaris(), "boormachine");
            Toevoegen.openVenster();
        } else if (input == 2) {
            Venster Toevoegen = new Toevoegen(getMedewerker(), getProductInventaris(), "personenauto");
            Toevoegen.openVenster();
        } else if (input == 3) {
            Venster Toevoegen = new Toevoegen(getMedewerker(), getProductInventaris(), "vrachtauto");
            Toevoegen.openVenster();
        }
        else {
            System.out.println("invoer niet correct, probeer opnieuw");
            scanner.nextInt();
        }
    }
}
