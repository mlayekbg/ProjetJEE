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

import com.pfa.model.Cadre;
import com.pfa.service.CadreService;

@RestController
@RequestMapping("/cadres")

public class CadreController {

    @Autowired
    private  final CadreService cadreservice;
    public CadreController(CadreService cadreservice) {
        this. cadreservice= cadreservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cadre>> getAllCadres () {
        List<Cadre> cadres =cadreservice.getAllCadres();
        return new ResponseEntity<>(cadres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cadre> getCadreById (@PathVariable("id") Long id) {
        Cadre cadre =cadreservice.getCadreById(id);
        return new ResponseEntity<>(cadre, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Cadre> createCadre(@RequestBody Cadre cadre) {
        Cadre newCadre =cadreservice.createCadre(cadre);
        return new ResponseEntity<>(newCadre, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cadre> updateCadre(@PathVariable("id") Long id,@RequestBody Cadre cadre) {
        Cadre newCadre =cadreservice.updateCadre(id,cadre);
        return new ResponseEntity<>(newCadre, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCadre(@PathVariable("id") Long id) {
        cadreservice. deleteCadre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


