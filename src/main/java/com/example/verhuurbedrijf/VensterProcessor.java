package com.example.verhuurbedrijf;

import com.example.verhuurbedrijf.Vensters.Menu;
import com.example.verhuurbedrijf.factorys.BoorMachineFactory;
import com.example.verhuurbedrijf.factorys.PersonenAutoFactory;
import com.example.verhuurbedrijf.factorys.VrachtAutoFactory;
import com.example.verhuurbedrijf.soorten.BoorMachine;
import com.example.verhuurbedrijf.soorten.PersonenAuto;
import com.example.verhuurbedrijf.soorten.VrachtAuto;

import java.util.ArrayList;

public class VensterProcessor {

    public static void main(String[] args) {
        BoorMachineFactory boorMachineFactory = new BoorMachineFactory("","","");
        PersonenAutoFactory personenAutoFactory = new PersonenAutoFactory("", "", 0, 0);
        VrachtAutoFactory vrachtAutoFactory = new VrachtAutoFactory("", 0, 0);

        BoorMachine boorMachine = boorMachineFactory.createProduct();
        boorMachine.setOmschrijving("Boormachine accu");
        boorMachine.setMerk("Bosch");
        boorMachine.setType("Klein");

        BoorMachine boorMachine2 = boorMachineFactory.createProduct();
        boorMachine2.setOmschrijving("Boormachine draad");
        boorMachine2.setMerk("Panasonic");
        boorMachine2.setType("Groot");

        PersonenAuto personenAuto = personenAutoFactory.createProduct();
        personenAuto.setOmschrijving("PersonenAuto 2 deurs");
        personenAuto.setMerk("Honda");
        personenAuto.setGewicht(3000);
        personenAuto.setMotorInhoud(100);

        PersonenAuto personenAuto2 = personenAutoFactory.createProduct();
        personenAuto2.setOmschrijving("PersonenAuto 4 deurs");
        personenAuto2.setMerk("Kia");
        personenAuto2.setGewicht(5000);
        personenAuto2.setMotorInhoud(150);

        VrachtAuto vrachtAuto = vrachtAutoFactory.createProduct();
        vrachtAuto.setOmschrijving("Scania");
        vrachtAuto.setLaadVermogen(10000);
        vrachtAuto.setMotorInhoud(300);

        VrachtAuto vrachtAuto2 = vrachtAutoFactory.createProduct();
        vrachtAuto2.setOmschrijving("Mercedes");
        vrachtAuto2.setLaadVermogen(15000);
        vrachtAuto2.setMotorInhoud(350);

        ProductInventaris productInventaris = new ProductInventaris();
        productInventaris.addProduct(boorMachine);
        productInventaris.addProduct(boorMachine2);
        productInventaris.addProduct(personenAuto);
        productInventaris.addProduct(personenAuto2);
        productInventaris.addProduct(vrachtAuto);
        productInventaris.addProduct(vrachtAuto2);

        Venster Menu = new Menu("Michael", productInventaris);
        productInventaris.addVenster(Menu);
        Menu.openVenster();
    }
}






