package com.pfa.repository;

import com.pfa.model.Cadre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
	public interface CadreRepository extends JpaRepository<Cadre, Long> {
	@Override
	List<Cadre> findAll();
}

