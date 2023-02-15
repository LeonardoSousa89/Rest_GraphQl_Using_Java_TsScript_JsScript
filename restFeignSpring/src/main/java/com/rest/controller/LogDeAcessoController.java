package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entitiesDTO.LogDeAcessoDTO;
import com.rest.services.LogDeAcessoServices;

@RestController
@RequestMapping("/logs")
public class LogDeAcessoController {

	@Autowired
	LogDeAcessoServices services;
	
	@GetMapping("/{id}")
	public ResponseEntity<LogDeAcessoDTO> logs(@PathVariable int id){
		
		 LogDeAcessoDTO log = services.logs(id);
		 return ResponseEntity.status(HttpStatus.OK).body(log);
	}
}
