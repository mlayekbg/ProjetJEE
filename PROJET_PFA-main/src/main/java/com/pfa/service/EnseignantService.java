package com.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfa.model.Enseignant;
import com.pfa.repository.EnseignantRepository;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    public Enseignant createEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    public Enseignant updateEnseignant(Long id, Enseignant enseignant) {
        Enseignant existingEnseignant = enseignantRepository.findById(id).orElse(null);
        if (existingEnseignant != null) {
            existingEnseignant.setNom(enseignant.getNom());
            existingEnseignant.setPrenom(enseignant.getPrenom());
            existingEnseignant.setEmail(enseignant.getEmail());
            existingEnseignant.setDepartement(enseignant.getDepartement());
            return enseignantRepository.save(existingEnseignant);
        } else {
            return null;
        }
    }

    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }
}