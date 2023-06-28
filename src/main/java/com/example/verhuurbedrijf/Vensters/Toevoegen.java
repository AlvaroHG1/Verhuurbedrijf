package com.example.verhuurbedrijf.Vensters;

import com.example.verhuurbedrijf.Observable;
import com.example.verhuurbedrijf.ProductFactory;
import com.example.verhuurbedrijf.ProductInventaris;
import com.example.verhuurbedrijf.Venster;
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
            voegBoormachineToe();
        } else if (productSoort.equals("personenauto")) {
            voegPersonenautoToe();
        } else {
            voegVrachtautoToe();
        }
        System.out.println("Succesvol toegevoegd");
        sluitVenster();
    }
    void voegBoormachineToe(){
        System.out.println("Boormachine");
        BoorMachine nieuweBoormachine = ProductFactory.Boor.createProduct();
        System.out.print("Omschrijving: ");
        nieuweBoormachine.setOmschrijving(scanner.nextLine());
        System.out.print("Merk: ");
        nieuweBoormachine.setMerk(scanner.nextLine());
        System.out.print("Type: ");
        nieuweBoormachine.setType(scanner.nextLine());
        productInventaris.addProduct(nieuweBoormachine);
    }
    void voegPersonenautoToe(){
        System.out.println("Personenauto");
        PersonenAuto nieuwePersonenAuto = ProductFactory.PersonenAuto.createProduct();
        System.out.print("Omschrijving: ");
        nieuwePersonenAuto.setOmschrijving(scanner.nextLine());
        System.out.print("Merk: ");
        nieuwePersonenAuto.setMerk(scanner.nextLine());
        System.out.print("Gewicht in kg: ");
        nieuwePersonenAuto.setGewicht(scanner.nextInt());
        System.out.print("Motorinhoud in cc: ");
        nieuwePersonenAuto.setMotorInhoud(scanner.nextInt());
        productInventaris.addProduct(nieuwePersonenAuto);
    }
    void voegVrachtautoToe(){
        System.out.println("Vrachtwagen");
        VrachtAuto nieuweVrachtAuto = ProductFactory.Vrachtauto.createProduct();
        System.out.print("Omschrijving: ");
        nieuweVrachtAuto.setOmschrijving(scanner.nextLine());
        System.out.print("Laadvermogen in kg: ");
        nieuweVrachtAuto.setLaadVermogen(scanner.nextInt());
        System.out.print("Motorinhoud in cc: ");
        nieuweVrachtAuto.setMotorInhoud(scanner.nextInt());
        productInventaris.addProduct(nieuweVrachtAuto);
    }
    @Override
    public void sluitVenster() {
        Venster Beheer = new Beheer(getMedewerker(), productInventaris);
        Beheer.openVenster();
    }
}
