package com.ceiba.cliente.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoCliente {

	ACTIVO("ACTIVO"), ELIMINADO("ELIMINADO");

	private String estado;

}
