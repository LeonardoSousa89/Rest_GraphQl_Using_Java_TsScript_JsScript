package com.mensagem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mensagem.entities.Frases;

@Repository
public interface FrasesRepository extends JpaRepository<Frases, Integer>{

	@Query(nativeQuery = true, value ="SELECT * FROM frases")
	Page<Frases> getFrases(Pageable paginacao);
}
