package com.ceiba.auto.servicio.testdatabuilder;

import com.ceiba.auto.comando.ComandoAuto;

public class ComandoAutoTestDataBuilder {

	private Long id;
	private String serial;
	private String nombre;
	private String modelo;
	private Double precioPorDia;
	private String estado;

	public ComandoAutoTestDataBuilder() {
		this.id = 1L;
		this.serial = "1234";
		this.nombre = "Auto 1";
		this.modelo = "2021";
		this.precioPorDia = 120000.00;
		this.estado = "DISPONIBLE";
	}

	public ComandoAutoTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoAutoTestDataBuilder conSerial(String serial) {
		this.serial = serial;
		return this;
	}

	public ComandoAutoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoAutoTestDataBuilder conModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public ComandoAutoTestDataBuilder conPrecioPorDia(Double precioPorDia) {
		this.precioPorDia = precioPorDia;
		return this;
	}

	public ComandoAuto build() {
		return new ComandoAuto(id, serial, nombre, modelo, precioPorDia, estado);
	}
}
