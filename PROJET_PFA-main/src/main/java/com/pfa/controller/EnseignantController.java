package com.pfa.controller;

import com.pfa.model.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.pfa.model.Enseignant;
import com.pfa.service.EnseignantService;

@RestController
@RequestMapping("/enseignants")

public class EnseignantController {

    @Autowired
    private  final EnseignantService enseignantservice;
    public EnseignantController(EnseignantService enseignantservice) {
        this. enseignantservice= enseignantservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Enseignant>> getAllEnseignants () {
        List<Enseignant> enseignants =  enseignantservice.getAllEnseignants();
        return new ResponseEntity<>(enseignants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getEnseignantById (@PathVariable("id") Long id) {
        Enseignant enseignant =  enseignantservice.getEnseignantById(id);
        return new ResponseEntity<>(enseignant, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Enseignant> createEnseignant(@RequestBody Enseignant enseignant) {
        Enseignant newEnseignant =enseignantservice.createEnseignant(enseignant);
        return new ResponseEntity<>(newEnseignant, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable("id") Long id,@RequestBody Enseignant enseignant) {
        Enseignant newEnseignant =enseignantservice.updateEnseignant(id,enseignant);
        return new ResponseEntity<>(newEnseignant, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEnseignant(@PathVariable("id") Long id) {
        enseignantservice. deleteEnseignant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


