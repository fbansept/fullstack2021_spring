package com.example.demo.model;

import com.example.demo.view.VueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;

@Entity
public class Chef extends Utilisateur {

    @JsonView(VueUtilisateur.class)
    private int nombreDeSalarie;

    public int getNombreDeSalarie() {
        return nombreDeSalarie;
    }

    public void setNombreDeSalarie(int nombreDeSalarie) {
        this.nombreDeSalarie = nombreDeSalarie;
    }
}
