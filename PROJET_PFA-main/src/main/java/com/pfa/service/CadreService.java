package com.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.model.Cadre;
import com.pfa.repository.CadreRepository;

@Service
public class CadreService {
    @Autowired
    private CadreRepository cadreRepository;

    public List<Cadre> getAllCadres() {
        return cadreRepository.findAll();
    }

    public Cadre getCadreById(Long id) {
        return cadreRepository.findById(id).orElse(null);
    }

    public Cadre createCadre(Cadre cadre) {
        return cadreRepository.save(cadre);
    }

    public Cadre updateCadre(Long id, Cadre cadre) {
        Cadre existingCadre = cadreRepository.findById(id).orElse(null);
        if (existingCadre != null) {
            existingCadre.setNom(cadre.getNom());
            existingCadre.setPrenom(cadre.getPrenom());
            existingCadre.setEmail(cadre.getEmail());
            existingCadre.setRole(cadre.getRole());
            return cadreRepository.save(existingCadre);
        } else {
            return null;
        }
    }

    public void deleteCadre(Long id) {
        cadreRepository.deleteById(id);
    }
}