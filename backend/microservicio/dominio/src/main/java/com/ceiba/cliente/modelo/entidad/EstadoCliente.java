package com.ceiba.cliente.modelo.entidad;

public enum EstadoCliente {

	ACTIVO("ACTIVO"), ELIMINADO("ELIMINADO");

	private String estado;

	private EstadoCliente(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
