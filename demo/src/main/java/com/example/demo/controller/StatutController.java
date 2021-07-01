package com.example.demo.controller;

import com.example.demo.dao.StatutDao;
import com.example.demo.model.Statut;
import com.example.demo.model.Utilisateur;
import com.example.demo.view.VueStatut;
import com.example.demo.view.VueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatutController {

    private StatutDao statutDao;

    @Autowired
    StatutController(StatutDao statutDao){
        this.statutDao = statutDao;
    }

    @GetMapping("/liste-statut")
    @JsonView(VueStatut.class)
    public List<Statut> afficheListeStatut () {
        return statutDao.findAll();
    }

    @GetMapping("/statut/{id}")
    @JsonView(VueStatut.class)
    public Statut afficheStatut(@PathVariable Integer id) {

        Statut statut = statutDao.findById(id).orElse(null);

        return statut;
    }

    @PostMapping("/statut")
    public boolean ajouterStatut(@RequestBody Statut statut) {

        statutDao.save(statut);

        return true;
    }

    @DeleteMapping("/statut/{id}")
    public boolean supprimerStatut(@PathVariable int id){
        statutDao.deleteById(id);
        return true;
    }
}
