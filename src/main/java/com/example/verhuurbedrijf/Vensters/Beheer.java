package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;
import java.util.Scanner;

public class Beheer extends Venster {

    public Beheer(String medewerker, ProductInventaris productInventaris, Scanner scanner) {
        super(medewerker, productInventaris, scanner);
    }

    @Override
    public void laadVenster() {
        System.out.println("----- Beheer -----");
        getProductInventaris().voegObserverToe(this);
        toonBeheer();
    }

    public void toonBeheer(){
        System.out.println("Welk soort product wilt u toevoegen?");
        System.out.println("1. Boormachine");
        System.out.println("2. Personenauto");
        System.out.println("3. Vrachtauto");
        int input = scanner.nextInt();
        if (input == 1){
            Venster Toevoegen = new Toevoegen(getMedewerker(), getProductInventaris(), scanner, "boormachine");
            Toevoegen.openVenster();
        } else if (input == 2) {
            Venster Toevoegen = new Toevoegen(getMedewerker(), getProductInventaris(), scanner,"personenauto");
            Toevoegen.openVenster();
        } else if (input == 3) {
            Venster Toevoegen = new Toevoegen(getMedewerker(), getProductInventaris(),scanner, "vrachtauto");
            Toevoegen.openVenster();
        }
        else {
            System.out.println("invoer niet correct, probeer opnieuw");
            scanner.nextInt();
        }
    }
    @Override
    public void sluitVenster() {

    }
}
