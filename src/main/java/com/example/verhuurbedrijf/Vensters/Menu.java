package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;

import java.util.Scanner;

public class Menu extends Venster{

    public Menu(String medewerker, ProductInventaris productInventaris, Scanner scanner) {
        super(medewerker, productInventaris, scanner);
    }

    @Override
    public void laadVenster() {
        getProductInventaris().voegObserverToe(this);
        System.out.println("----- Menu -----");
        opties();
    }

    void opties(){
        System.out.println("1. Overzicht");
        System.out.println("2. Toevoegen");
        int input = scanner.nextInt();

        if (input == 1){
            Venster Overzicht = new Overzicht(getMedewerker(), getProductInventaris(), scanner);
            Overzicht.openVenster();
        }
        else {
            Venster Beheer = new Beheer(getMedewerker(), getProductInventaris(), scanner);
            Beheer.openVenster();
        }
    }
    @Override
    public void sluitVenster() {
        logout();
    }

    private void logout() {
        System. exit(0);
    }

}
