package com.rest.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.LogDeAcesso;
import com.rest.entitiesDTO.FrasesDTO;
import com.rest.entitiesDTO.LogDeAcessoDTO;
import com.rest.feignClient.FrasesFeignClient;
import com.rest.repositories.LogDeAcessoRepository;

@Service
public class LogDeAcessoServices {

	@Autowired
	FrasesFeignClient frasesFeignClient;
	
	@Autowired
	LogDeAcessoRepository repository;
	
	Instant instant = Instant.now();
	
	private String nova_frase;
	
	
	
	public FrasesDTO requisicao(int id) {
		
		FrasesDTO frase = frasesFeignClient.getFraseById(id).getBody();
		return frase;
	}
	
	
	public LogDeAcessoDTO logs(int id) {
		
		LogDeAcesso log = new LogDeAcesso();
		
		FrasesDTO frase = requisicao(id);
		
		String frase_do_usuario = frase.getFrase_do_usuario();
		
		salvarRegistro(frase_do_usuario);
		
		return new LogDeAcessoDTO(log, frase);
	}
	
	
	public void salvarRegistro(String frase_do_usuario) {
		
		this.nova_frase = frase_do_usuario;
		
		LogDeAcesso novaFrase = new LogDeAcesso();
		novaFrase.setFrase_do_usuario(this.nova_frase);
		
		LogDeAcesso fraseDeRegistro = new LogDeAcesso();
		fraseDeRegistro.setFrase_do_usuario(novaFrase.getFrase_do_usuario());
		
		repository.save(fraseDeRegistro);
	}
}
