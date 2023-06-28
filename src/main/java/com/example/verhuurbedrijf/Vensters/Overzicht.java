package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.Product;
import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.ProductObserver;
import com.example.verhuurbedrijf.Venster;

import java.util.ArrayList;
import java.util.Scanner;

public class Overzicht extends Venster{
    private ProductInventaris productInventaris;
    public Overzicht(String medewerker, ProductInventaris productInventaris) {
        super(medewerker);
        this.productInventaris = productInventaris;
    }

    @Override
    public void laadVenster() {
        System.out.println("je bent nu in venster overzicht");
        toonOverzicht();
    }

    public void toonOverzicht() {
        Scanner scanner = new Scanner(System.in);
        int productNummer = 1;
        System.out.println("----- Overzicht van producten -----");
        for (Product product : productInventaris.getProducten()) {
            System.out.println(productNummer + ". Omschrijving: " + product.getOmschrijving());
            System.out.println("Verhuurd: " + (product.isVerhuurd() ? "Ja" : "Nee"));
            System.out.println("-----------------------------------");
            productNummer++;
        }
        System.out.println(productNummer +". Sluit venster");
        System.out.println("kies een product");

        int keuze = scanner.nextInt();
        if (keuze == productNummer){
            sluitVenster();
        }
        else {
            Venster ProductDetails = new ProductDetails(getMedewerker(), productInventaris.getProduct(keuze - 1), productInventaris);
            productInventaris.addVenster(ProductDetails);
            ProductDetails.openVenster();
        }
    }
    @Override
    public void sluitVenster() {
        super.sluitVenster();
    }


}
