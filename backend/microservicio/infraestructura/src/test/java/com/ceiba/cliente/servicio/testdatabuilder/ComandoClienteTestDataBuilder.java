package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

public class ComandoClienteTestDataBuilder {

	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String cedula;

	public ComandoClienteTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Nombre de prueba";
		this.apellido = "Apellido de prueba";
		this.direccion = "Direccion de prueba";
		this.cedula = "109499999";
	}

	public ComandoClienteTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoClienteTestDataBuilder conApellido(String apellido) {
		this.apellido = apellido;
		return this;
	}

	public ComandoClienteTestDataBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public ComandoClienteTestDataBuilder conCedula(String cedula) {
		this.cedula = cedula;
		return this;
	}

	public ComandoCliente build() {
		return new ComandoCliente(id, nombre, apellido, direccion, cedula);
	}
}
