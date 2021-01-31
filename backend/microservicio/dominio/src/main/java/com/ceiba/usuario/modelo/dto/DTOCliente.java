package com.ceiba.usuario.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DTOCliente {

	private Long id;
	private String nombre;
	private String cedula;
	private LocalDateTime fechaCreacion;
}
