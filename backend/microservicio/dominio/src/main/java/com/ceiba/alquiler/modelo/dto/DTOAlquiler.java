package com.ceiba.alquiler.modelo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ceiba.auto.modelo.dto.DTOAuto;
import com.ceiba.cliente.modelo.dto.DTOCliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DTOAlquiler {

	private Long id;
	private DTOAuto auto;
	private DTOCliente cliente;
	private Double subTotal;
	private Double descuento;
	private Double total;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private LocalDateTime fechaCreacion;

}
