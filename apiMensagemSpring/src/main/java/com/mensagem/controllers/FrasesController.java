package com.mensagem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mensagem.DTO.FrasesDTO;
import com.mensagem.entities.Frases;
import com.mensagem.services.FrasesService;

//apoio
//https://spring.io/guides/gs/rest-service-cors/
//https://stackoverflow.com/questions/56927217/how-to-enable-cors-in-spring-boot-not-working
//https://www.baeldung.com/spring-cors

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/frase")
public class FrasesController {

	
	@Autowired
	FrasesService service;
	
	@PostMapping
	public ResponseEntity<Object> addFrase(@RequestBody Frases frase){
	
		service.addFrase(frase);
		return ResponseEntity.status(HttpStatus.CREATED).body("frase inserida com sucesso");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> updateFrase(@PathVariable int id, @RequestBody Frases resource){
		
		service.updateFrase(id, resource);
		return ResponseEntity.status(HttpStatus.CREATED).body("frase do usuário atualizada com sucesso");
	}
	
	@GetMapping(value = "/frases")
	public ResponseEntity<List<FrasesDTO>> getFrases(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "3") int size
			){
		
		PageRequest paginacao = PageRequest.of(page, size);
				
		List<FrasesDTO> frases = service.getFrases(paginacao);
		return ResponseEntity.status(HttpStatus.OK).body(frases);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FrasesDTO> getFraseById(@PathVariable int id){
		
		FrasesDTO fraseDoUsuario = service.getFraseById(id);
		return ResponseEntity.status(HttpStatus.OK).body(fraseDoUsuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteFraseById(@PathVariable int id){
		
		service.deleteFraseById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
