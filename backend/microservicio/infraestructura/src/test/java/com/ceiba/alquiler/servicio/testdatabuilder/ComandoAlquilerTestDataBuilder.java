package com.ceiba.alquiler.servicio.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.alquiler.comando.ComandoAlquiler;

public class ComandoAlquilerTestDataBuilder {

	private Long id;
    private Long autoId;
    private Long clienteId;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;

	public ComandoAlquilerTestDataBuilder() {
		this.id = 1L;
		this.autoId = 2L;
		this.clienteId = 2L;
		this.fechaAlquiler = LocalDate.now().plusDays(1);
		this.fechaDevolucion = LocalDate.now().plusDays(6);
	}

	public ComandoAlquilerTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoAlquilerTestDataBuilder conAutoId(Long autoId) {
		this.autoId = autoId;
		return this;
	}

	public ComandoAlquilerTestDataBuilder conClienteId(Long clienteId) {
		this.clienteId = clienteId;
		return this;
	}

	public ComandoAlquilerTestDataBuilder conFechaAlquiler(LocalDate fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
		return this;
	}

	public ComandoAlquilerTestDataBuilder conFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
		return this;
	}

	public ComandoAlquiler build() {
		return new ComandoAlquiler(id, autoId, clienteId, fechaAlquiler, fechaDevolucion);
	}
}
