package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.Product;
import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;

import java.util.Scanner;

public class Overzicht extends Venster{

    public Overzicht(String medewerker, ProductInventaris productInventaris, Scanner scanner) {
        super(medewerker, productInventaris, scanner);
    }

    @Override
    public void laadVenster() {
        getProductInventaris().voegObserverToe(this);
        System.out.println("----- Overzicht van producten -----");
        toonOverzicht();
    }

    public void toonOverzicht() {
        int productNummer = 1;
        for (Product product : getProductInventaris().getProducten()) {
            System.out.println(productNummer + ". Omschrijving: " + product.getOmschrijving());
            System.out.println("Verhuurd: " + (product.isVerhuurd() ? "Ja" : "Nee"));
            System.out.println("-----------------------------------");
            productNummer++;
        }
        System.out.println(productNummer +". Sluit venster\n");
        System.out.print("Kies voor meer details: ");
        int keuze = scanner.nextInt();
        if (keuze == productNummer){
            sluitVenster();
        }
        else {
            Venster ProductDetails = new ProductDetails(getMedewerker(), getProductInventaris(), scanner, getProductInventaris().getProduct(keuze - 1));
            ProductDetails.openVenster();
        }
    }
    @Override
    public void sluitVenster() {
        Venster menu = new Menu("Michael", getProductInventaris(), scanner);
        menu.openVenster();
    }
}
