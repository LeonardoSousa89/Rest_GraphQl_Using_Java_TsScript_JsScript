package com.rest.entitiesDTO;

import java.io.Serializable;

import com.rest.entities.Frases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FrasesDTO implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private int id;
	private String frase_do_usuario;
	
	public FrasesDTO(Frases frase) {
		this.id = frase.getId();
		this.frase_do_usuario = frase.getFrase_do_usuario();
	}
}
