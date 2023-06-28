package com.example.verhuurbedrijf;

import com.example.verhuurbedrijf.factorys.BoorMachineFactory;
import com.example.verhuurbedrijf.factorys.PersonenAutoFactory;
import com.example.verhuurbedrijf.factorys.VrachtAutoFactory;

public abstract class ProductFactory {
    public static final BoorMachineFactory Boor = new BoorMachineFactory ();
    public static final PersonenAutoFactory PersonenAuto = new PersonenAutoFactory ();
    public static final VrachtAutoFactory Vrachtauto = new VrachtAutoFactory ();


    public abstract Product createProduct();
}
