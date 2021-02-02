package com.ceiba.alquiler.servicio.testdatabuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

public class AlquilerTestDataBuilder {

	private Long id;
	private Auto auto;
	private Cliente cliente;
	private Double subTotal;
	private Double descuento;
	private Double total;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private LocalDateTime fechaCreacion;

	public AlquilerTestDataBuilder() {
		this.id = 1L;
		this.auto = new AutoTestDataBuilder().build();
		this.cliente = new ClienteTestDataBuilder().build();
		this.subTotal = 200000.00;
		this.descuento = 20000.00;
		this.total = 180000.00;
		this.fechaAlquiler = LocalDate.now().plusDays(1);
		this.fechaDevolucion = LocalDate.now().plusDays(6);
		this.fechaCreacion = LocalDateTime.parse("2021-02-01T13:00:00");
	}

	public AlquilerTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public AlquilerTestDataBuilder conAuto(Auto auto) {
		this.auto = auto;
		return this;
	}

	public AlquilerTestDataBuilder conCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public AlquilerTestDataBuilder conSubTotal(Double subTotal) {
		this.subTotal = subTotal;
		return this;
	}

	public AlquilerTestDataBuilder conDescuento(Double descuento) {
		this.descuento = descuento;
		return this;
	}
	
	public AlquilerTestDataBuilder conTotal(Double total) {
		this.total = total;
		return this;
	}
	
	public AlquilerTestDataBuilder conFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        return this;
    }
	
	public AlquilerTestDataBuilder conFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        return this;
    }
	
	public AlquilerTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

	public Alquiler build() {
		Alquiler alquiler = new Alquiler(id, fechaAlquiler, fechaDevolucion);
		alquiler.asignarAuto(auto);
		alquiler.asignarCliente(cliente);
		alquiler.setSubTotal(subTotal);
		alquiler.setDescuento(descuento);
		alquiler.setTotal(total);
		alquiler.setFechaCreacion(fechaCreacion);
		return alquiler;
	}
}
