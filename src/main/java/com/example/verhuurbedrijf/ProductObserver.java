package com.example.verhuurbedrijf;

public interface ProductObserver {
    void alsVeranderd(Product product);
    void alsToegevoegd(Product product);
}

