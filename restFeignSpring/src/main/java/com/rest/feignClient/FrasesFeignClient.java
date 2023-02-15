package com.rest.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest.entitiesDTO.FrasesDTO;

@Component
@FeignClient(name = "apiMensagemSpring", url = "http://localhost:8082", path = "/frase")
public interface FrasesFeignClient {

	@GetMapping(value = "/{id}")
	ResponseEntity<FrasesDTO> getFraseById(@PathVariable int id);
	
}
