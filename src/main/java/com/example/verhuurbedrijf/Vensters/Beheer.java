package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.ProductFactory;
import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;
import com.example.verhuurbedrijf.factorys.BoorMachineFactory;

import java.util.Scanner;

public class Beheer extends Venster {
    private ProductInventaris productInventaris;
    public Beheer(String medewerker, ProductInventaris productInventaris) {
        super(medewerker);
        this.productInventaris = productInventaris;
    }

    @Override
    public void laadVenster() {
        productInventaris.voegObserverToe(this);
        toonBeheer();
    }

    public void toonBeheer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Je bent in het beheer venster");
        System.out.println("Welk soort product wilt u toevoegen?");
        System.out.println("1. Boormachine");
        System.out.println("2. Personenauto");
        System.out.println("3. Vrachtauto");
        int input = scanner.nextInt();
        if (input == 1){
            Venster Toevoegen = new Toevoegen(getMedewerker(), productInventaris, "boormachine");
            Toevoegen.openVenster();
        } else if (input == 2) {
            Venster Toevoegen = new Toevoegen(getMedewerker(), productInventaris, "personenauto");
            Toevoegen.openVenster();
        } else if (input == 3) {
            Venster Toevoegen = new Toevoegen(getMedewerker(), productInventaris, "vrachtauto");
            Toevoegen.openVenster();
        }
        else {
            System.out.println("invoer niet correct, probeer opnieuw");
            scanner.nextInt();
        }
    }
}
