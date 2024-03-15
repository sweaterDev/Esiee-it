package com.example.projetgreta2.model;

public class Specialite {
    private int id_matiere;
    private int id_compte;

    public Specialite(int id_matiere, int id_compte) {
        this.id_matiere = id_matiere;
        this.id_compte = id_compte;
    }
public  Specialite() {}
    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public int getId_compte() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }
}
