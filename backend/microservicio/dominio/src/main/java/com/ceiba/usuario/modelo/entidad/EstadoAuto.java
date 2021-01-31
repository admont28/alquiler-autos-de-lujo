package com.ceiba.usuario.modelo.entidad;

public enum EstadoAuto {

	DISPONIBLE("DISPONIBLE"), ELIMINADO("ELIMINADO"), ALQUILADO("ALQUILADO");
	
	private String estado;

	private EstadoAuto(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
