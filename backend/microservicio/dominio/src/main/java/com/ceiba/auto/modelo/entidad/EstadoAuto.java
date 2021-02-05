package com.ceiba.auto.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoAuto {

	DISPONIBLE("DISPONIBLE"), MANTENIMIENTO("MANTENIMIENTO"), ELIMINADO("ELIMINADO"), ALQUILADO("ALQUILADO");
	
	private String estado;
	
}
