package com.ceiba.auto.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoAuto {

	DISPONIBLE("DISPONIBLE"), ELIMINADO("ELIMINADO"), ALQUILADO("ALQUILADO");
	
	private String estado;
	
}
