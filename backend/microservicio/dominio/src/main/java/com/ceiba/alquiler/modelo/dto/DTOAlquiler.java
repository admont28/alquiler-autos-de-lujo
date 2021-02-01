package com.ceiba.alquiler.modelo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DTOAlquiler {

	private Long id;
	private Long autoId;
	private Long clienteId;
	private Double subTotal;
	private Double descuento;
	private Double total;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private LocalDateTime fechaCreacion;

}
