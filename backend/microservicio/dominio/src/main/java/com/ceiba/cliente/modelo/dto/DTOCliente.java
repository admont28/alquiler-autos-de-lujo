package com.ceiba.cliente.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.entidad.EstadoCliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DTOCliente {

	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String cedula;
	private EstadoCliente estado;
	private LocalDateTime fechaCreacion;
}
