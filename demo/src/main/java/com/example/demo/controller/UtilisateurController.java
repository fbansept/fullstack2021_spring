package com.example.demo.controller;

import com.example.demo.dao.UtilisateurDao;
import com.example.demo.model.Utilisateur;
import com.example.demo.view.VueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    private UtilisateurDao utilisateurDao;

    @Autowired
    UtilisateurController(UtilisateurDao utilisateurDao){
        this.utilisateurDao = utilisateurDao;
    }

    @GetMapping("/liste-utilisateur")
    @JsonView(VueUtilisateur.class)
    public List<Utilisateur> afficheListeUtilisateur () {
        return utilisateurDao.findAll();
    }


    @GetMapping("/utilisateur/{id}")
    @JsonView(VueUtilisateur.class)
    public ResponseEntity<Utilisateur> afficheUtilisateur(@PathVariable Integer id) {

        Optional<Utilisateur> utilisateur = utilisateurDao.findById(id);

        if(utilisateur.isPresent()){
            return ResponseEntity.ok(utilisateur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/utilisateur-nom/{nom}")
    @JsonView(VueUtilisateur.class)
    public Utilisateur afficheUtilisateurParNom(@PathVariable String nom) {

        return utilisateurDao.findByNom(nom);
    }

    @PostMapping("/utilisateur")
    public ResponseEntity<String> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {

        utilisateurDao.saveAndFlush(utilisateur);

        return ResponseEntity.created(
                URI.create("/utilisateur/" + utilisateur.getId())
        ).build();
    }

    @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<Integer> supprimerUtilisateur(@PathVariable int id){

        if(utilisateurDao.existsById(id)) {
            utilisateurDao.deleteById(id);
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
