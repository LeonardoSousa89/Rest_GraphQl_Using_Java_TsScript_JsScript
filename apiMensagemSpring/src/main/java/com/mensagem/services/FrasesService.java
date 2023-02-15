package com.mensagem.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensagem.DTO.FrasesDTO;
import com.mensagem.entities.Frases;
import com.mensagem.repositories.FrasesRepository;

@Service
public class FrasesService {

	@Autowired
	FrasesRepository repository;
	
	
	public void addFrase(Frases frase) {
		repository.save(frase);
	}
	
	public List<FrasesDTO> getFrases(){
		
		List <Frases> frases = repository.findAll();
		
		List<FrasesDTO> frasesDTO = frases.stream()
										  .map(listaDeFrases -> new FrasesDTO(listaDeFrases))
										  .collect(Collectors.toList());		
		
		return frasesDTO;
	}
	
	public FrasesDTO getFraseById(int id) {
		
		Frases frase = repository.findById(id).get();
		
		FrasesDTO fraseDTO = new FrasesDTO(frase);
		
		return 	fraseDTO;
	}
	
	
	public void updateResource(Frases newResource, Frases resource) {
		
		newResource.setFrase_do_usuario(resource.getFrase_do_usuario());
	}
	
	public void updateFrase(int id, Frases resource) {
		
		Frases newResource = repository.getOne(id);
		updateResource(newResource, resource);
		repository.save(newResource);
	}
	
	public void deleteFraseById(int id) {
		
		repository.deleteById(id);
	}
}
