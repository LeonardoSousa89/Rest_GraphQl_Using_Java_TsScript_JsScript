package com.mensagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mensagem.entities.Frases;

@Repository
public interface FrasesRepository extends JpaRepository<Frases, Integer>{

}
