package com.ceiba.auto.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.auto.modelo.entidad.EstadoAuto;

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
	private String urlImagen;
	private LocalDateTime fechaCreacion;
}
