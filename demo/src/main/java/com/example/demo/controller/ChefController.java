package com.example.demo.controller;

import com.example.demo.dao.ChefDao;
import com.example.demo.model.Chef;
import com.example.demo.view.VueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChefController {

    private ChefDao chefDao;

    @Autowired
    ChefController(ChefDao chefDao){
        this.chefDao = chefDao;
    }

    @GetMapping("/liste-chef")
    @JsonView(VueUtilisateur.class)
    public List<Chef> afficheListeChef () {
        return chefDao.findAll();
    }

    @GetMapping("/chef/{id}")
    @JsonView(VueUtilisateur.class)
    public Chef afficheChef(@PathVariable Integer id) {

        Chef chef = chefDao.findById(id).orElse(null);

        return chef;
    }

    @PostMapping("/chef")
    public boolean ajouterChef(@RequestBody Chef chef) {

        chefDao.save(chef);

        return true;
    }

    @DeleteMapping("/chef/{id}")
    public boolean supprimerChef(@PathVariable int id){
        chefDao.deleteById(id);
        return true;
    }
}
