package com.ceiba.auto.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.modelo.entidad.EstadoAuto;

public class AutoTestDataBuilder {

	private Long id;
	private String serial;
	private String nombre;
	private String modelo;
	private Double precioPorDia;
	private EstadoAuto estado;
	private LocalDateTime fechaCreacion;

	public AutoTestDataBuilder() {
		this.id = 1L;
		this.serial = "1234";
		this.nombre = "Auto 1";
		this.modelo = "2021";
		this.precioPorDia = 120000.00;
		this.estado = EstadoAuto.DISPONIBLE;
		this.fechaCreacion = LocalDateTime.now();
	}

	public AutoTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public AutoTestDataBuilder conSerial(String serial) {
		this.serial = serial;
		return this;
	}

	public AutoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public AutoTestDataBuilder conModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public AutoTestDataBuilder conPrecioPorDia(Double precioPorDia) {
		this.precioPorDia = precioPorDia;
		return this;
	}
	
	public AutoTestDataBuilder conEstado(EstadoAuto estado) {
		this.estado = estado;
		return this;
	}
	
	public AutoTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

	public Auto build() {
		return new Auto(id, serial, nombre, modelo, precioPorDia, estado, fechaCreacion);
	}
}
