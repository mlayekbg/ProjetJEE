package com.pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfa.model.Etudiant;

import java.util.List;

@Repository
	public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	@Override
	List<Etudiant> findAll();
}

