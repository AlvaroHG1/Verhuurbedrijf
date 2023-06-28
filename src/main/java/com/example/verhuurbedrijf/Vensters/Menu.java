package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.Product;
import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Venster{

    public Menu(String medewerker, ProductInventaris productInventaris) {
        super(medewerker, productInventaris);
    }

    @Override
    public void laadVenster() {
        getProductInventaris().voegObserverToe(this);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Je bent nu in venster Menu");
        System.out.println("Waar wil je heen");
        System.out.println("1. Overzicht");
        System.out.println("2. Toevoegen");
        int input = scanner.nextInt();
        if (input == 1){
            Venster Overzicht = new Overzicht(getMedewerker(), getProductInventaris());
            Overzicht.openVenster();
        }
        else {
            Venster Beheer = new Beheer(getMedewerker(), getProductInventaris());
            Beheer.openVenster();
        }
    }
    @Override
    public void sluitVenster() {
        logout();
    }

    private void logout() {
    }

}
