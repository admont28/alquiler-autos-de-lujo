package com.ceiba.usuario.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.usuario.modelo.entidad.EstadoAuto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DTOAuto {

	private Long id;
	private String serial;
	private String nombre;
	private String modelo;
	private Double precioPorDia;
	private EstadoAuto estado;
	private LocalDateTime fechaCreacion;
}
