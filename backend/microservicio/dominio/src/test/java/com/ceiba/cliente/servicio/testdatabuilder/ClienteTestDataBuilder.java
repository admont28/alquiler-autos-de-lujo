package com.ceiba.cliente.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;

public class ClienteTestDataBuilder {

	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String cedula;
	private EstadoCliente estado;
	private LocalDateTime fechaCreacion;

	public ClienteTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Nombre de prueba";
		this.apellido = "Apellido de prueba";
		this.direccion = "Direccion de prueba";
		this.cedula = "109499999";
		this.estado = EstadoCliente.ACTIVO;
		this.fechaCreacion = LocalDateTime.now();
	}

	public ClienteTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ClienteTestDataBuilder conApellido(String apellido) {
		this.apellido = apellido;
		return this;
	}

	public ClienteTestDataBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public ClienteTestDataBuilder conCedula(String cedula) {
		this.cedula = cedula;
		return this;
	}
	
	public ClienteTestDataBuilder conEstado(EstadoCliente estado) {
		this.estado = estado;
		return this;
	}
	
	public ClienteTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

	public Cliente build() {
		Cliente cliente = new Cliente(id, nombre, apellido, direccion, cedula, estado);
		cliente.setFechaCreacion(fechaCreacion);
		return cliente;
	}
}
