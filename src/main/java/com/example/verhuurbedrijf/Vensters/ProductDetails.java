package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.Product;
import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductDetails extends Venster {
    private Product product;
    private Scanner scanner;
    private ProductInventaris productInventaris;

    public ProductDetails(String medewerker, Product product, ProductInventaris productInventaris) {
        super(medewerker);
        this.product = product;
        this.productInventaris = productInventaris;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void laadVenster() {
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
        super.sluitVenster();
    }
}