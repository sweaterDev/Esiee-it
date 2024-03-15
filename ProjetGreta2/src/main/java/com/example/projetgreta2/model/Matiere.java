package com.example.projetgreta2.model;

public class Matiere {
    String nom;
    int id;

    public Matiere(){}

    public Matiere(int id, String nom) {
        this.nom = nom;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
