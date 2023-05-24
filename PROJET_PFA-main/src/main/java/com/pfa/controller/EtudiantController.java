package com.pfa.controller;

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

import com.pfa.model.Etudiant;
import com.pfa.service.EtudiantService;

@RestController
@RequestMapping("/etudiants")

public class EtudiantController {
	
	    @Autowired
	    private  final EtudiantService etudiantservice;
	    public EtudiantController(EtudiantService etudiantservice) {
	    	this. etudiantservice= etudiantservice;
	    }
	    
	    @GetMapping("/all")
	    public ResponseEntity<List<Etudiant>> getAllEtudiants () {
	        List<Etudiant> etudiants =  etudiantservice.getAllEtudiants();
	        return new ResponseEntity<>(etudiants, HttpStatus.OK);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Etudiant> getEtudiantById (@PathVariable("id") Long id) {
	        Etudiant etudiant =  etudiantservice.getEtudiantById(id);
	        return new ResponseEntity<>(etudiant, HttpStatus.OK);
	    }
	   
	   
	    @PostMapping("/add")
	    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
	    	Etudiant newEtudiant =etudiantservice.createEtudiant(etudiant);
	        return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED);
	    }
	    
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable("id") Long id,@RequestBody Etudiant etudiant) {
	    	Etudiant newEtudiant =etudiantservice.updateEtudiant(id,etudiant);
	        return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED);
	    }
	    
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEtudiant(@PathVariable("id") Long id) {
	    	etudiantservice. deleteEtudiant(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	}


