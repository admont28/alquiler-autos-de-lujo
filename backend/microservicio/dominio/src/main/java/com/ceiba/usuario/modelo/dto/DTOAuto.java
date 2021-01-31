package com.ceiba.usuario.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DTOAuto {

	private Long id;
	private String nombre;
	private String modelo;
	private Double precioPorDia;
	private LocalDateTime fechaCreacion;
}
