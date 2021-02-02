package com.ceiba.auto.modelo.entidad;

public enum EstadoAuto {

	DISPONIBLE("DISPONIBLE"), ELIMINADO("ELIMINADO"), ALQUILADO("ALQUILADO");
	
	private String estado;

	private EstadoAuto(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
	
}
