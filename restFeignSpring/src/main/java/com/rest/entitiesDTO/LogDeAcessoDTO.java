package com.rest.entitiesDTO;

import java.io.Serializable;
import java.time.Instant;

import com.rest.entities.LogDeAcesso;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class LogDeAcessoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String frase_do_usuario;
	private Instant horario_de_acesso;
	
	
	
	public LogDeAcessoDTO(LogDeAcesso log, FrasesDTO frase) {
		
		this.id = frase.getId();
		this.frase_do_usuario  = frase.getFrase_do_usuario();
		this.horario_de_acesso = log.getHorario_de_acesso();
	}
	
	public LogDeAcessoDTO(LogDeAcesso log) {
		
		this.id = log.getId();
		this.frase_do_usuario  = log.getFrase_do_usuario();
		this.horario_de_acesso = log.getHorario_de_acesso();
	}
}
