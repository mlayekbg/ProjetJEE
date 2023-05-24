package com.pfa.repository;

import com.pfa.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
	public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	@Override
	List<Enseignant> findAll();
}

