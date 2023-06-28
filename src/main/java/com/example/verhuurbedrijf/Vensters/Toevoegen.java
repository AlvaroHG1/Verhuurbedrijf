package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.ProductFactory;
import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;
import com.example.verhuurbedrijf.factorys.BoorMachineFactory;
import com.example.verhuurbedrijf.factorys.PersonenAutoFactory;
import com.example.verhuurbedrijf.factorys.VrachtAutoFactory;
import com.example.verhuurbedrijf.soorten.BoorMachine;
import com.example.verhuurbedrijf.soorten.PersonenAuto;
import com.example.verhuurbedrijf.soorten.VrachtAuto;

import java.util.Scanner;

public class Toevoegen extends Venster {
    private ProductInventaris productInventaris;
    private String productSoort;
    Scanner scanner = new Scanner(System.in);
    public Toevoegen(String medewerker, ProductInventaris productInventaris, String productSoort) {
        super(medewerker);
        this.productInventaris = productInventaris;
        this.productSoort = productSoort;
    }

    @Override
    public void laadVenster() {
        productInventaris.voegObserverToe(this);
        System.out.println("Product toevoegen:");
        voegProductToe();
    }

    void voegProductToe(){

        if (productSoort.equals("boormachine")) {
            System.out.println("Boormachine");
            System.out.print("Omschrijving: ");
            String omschrijving = scanner.nextLine();
            System.out.print("Merk: ");
            String merk = scanner.nextLine();
            System.out.print("Type: ");
            String type = scanner.nextLine();
            BoorMachine nieuweBoormachine = ProductFactory.Boor.createProduct();
            nieuweBoormachine.setOmschrijving(omschrijving);
            nieuweBoormachine.setMerk(merk);
            nieuweBoormachine.setType(type);
            productInventaris.addProduct(nieuweBoormachine);
        } else if (productSoort.equals("personenauto")) {
            System.out.println("Personenauto");
            System.out.print("Omschrijving: ");
            String omschrijving = scanner.nextLine();
            System.out.print("Merk: ");
            String merk = scanner.nextLine();
            System.out.print("Gewicht in kg: ");
            int gewicht = scanner.nextInt();
            System.out.print("Motorinhoud in cc: ");
            int motorInhoud = scanner.nextInt();
            PersonenAuto nieuwePersonenAuto = ProductFactory.PersonenAuto.createProduct();
            nieuwePersonenAuto.setOmschrijving(omschrijving);
            nieuwePersonenAuto.setMerk(merk);
            nieuwePersonenAuto.setGewicht(gewicht);
            nieuwePersonenAuto.setMotorInhoud(motorInhoud);
        } else {
            System.out.println("Vrachtwagen");
            System.out.print("Omschrijving: ");
            String omschrijving = scanner.nextLine();
            System.out.print("Laadvermogen in kg: ");
            int laadvermogen = scanner.nextInt();
            System.out.print("Motorinhoud in cc: ");
            int motorInhoud = scanner.nextInt();
            VrachtAuto nieuweVrachtAuto = ProductFactory.Vrachtauto.createProduct();
            nieuweVrachtAuto.setOmschrijving(omschrijving);
            nieuweVrachtAuto.setLaadVermogen(laadvermogen);
            nieuweVrachtAuto.setMotorInhoud(motorInhoud);
        }
        System.out.println("Succesvol toegevoegd");
        sluitVenster();
    }

    @Override
    public void sluitVenster() {
        Venster Beheer = new Beheer(getMedewerker(), productInventaris);
        Beheer.openVenster();
    }
}
