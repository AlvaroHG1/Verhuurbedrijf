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
            toonRetournerenOptie();
        } else {
            System.out.println("1. Verhuren");
        }

        int keuze = scanner.nextInt();
        scanner.nextLine();

        switch (keuze) {
            case 1:
                if (product.isVerhuurd()) {
                    product.retourProduct();
                } else {
                    toonVerhurenOptie();
                }
                break;
            case 2:
                sluitVenster();
                break;
            default:
                System.out.println("Ongeldige keuze.");
                break;
        }
    }

    private void toonRetournerenOptie() {
        System.out.println("Verhuurder: " + product.getContract().getVerhuurder());
        System.out.println("Klantnaam: " + product.getContract().getVerhuurder());
        System.out.println("1. Retourneren");
        System.out.println("2. Venster sluiten");
    }

    private void toonVerhurenOptie() {
        System.out.print("Verhuurder: " + getMedewerker());
        System.out.print("\nKlantnaam: ");
        String klantNaam = scanner.nextLine();
        product.verhuurProduct(getMedewerker(), klantNaam);
    }

    @Override
    public void sluitVenster() {
        Venster Overzicht = new Overzicht(getMedewerker(), getProductInventaris(), scanner);
        Overzicht.openVenster();
    }
}