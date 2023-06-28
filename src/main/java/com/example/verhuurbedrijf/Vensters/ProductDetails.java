package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.Product;
import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductDetails extends Venster {
    private Product product;

    public ProductDetails(String medewerker, ProductInventaris productInventaris, Scanner scanner, Product product) {
        super(medewerker, productInventaris, scanner);
        this.product = product;
    }

    @Override
    public void laadVenster() {
        getProductInventaris().voegObserverToe(this);
        toonDetails();
    }

    public void toonDetails() {
        System.out.println("Omschrijving: " + product.getOmschrijving() + product.toonDetails());
        System.out.println("Verhuurd: " + (product.isVerhuurd() ? "Ja" : "Nee"));

        if (product.isVerhuurd()) {
            System.out.println("Verhuurder: " + product.getVerhuurder());
            System.out.println("Klantnaam: " + product.getKlantNaam());
            System.out.println("1. Retourneren");
        } else {
            System.out.println("1. Verhuren");
        }

        System.out.println("2. Terug naar overzicht");

        int keuze = scanner.nextInt();
        scanner.nextLine(); // Om de nieuwe regel na het getal te consumeren

        switch (keuze) {
            case 1:
                if (product.isVerhuurd()) {
                    product.retourProduct();
                } else {
                    System.out.print("Verhuurder: " + getMedewerker());
                    System.out.print("\nKlantnaam: ");
                    String klantNaam = scanner.nextLine();
                    product.verhuurProduct(getMedewerker(), klantNaam);
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Ongeldige keuze.");
                break;
        }
    }

    @Override
    public void sluitVenster() {
    }
}