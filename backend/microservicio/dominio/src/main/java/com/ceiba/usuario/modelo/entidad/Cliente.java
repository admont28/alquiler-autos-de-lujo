package com.ceiba.usuario.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Cliente {

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente";
	private static final String SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE = "Se debe ingresar la cédula del cliente";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación del cliente";

	private Long id;
	private String nombre;
	private String cedula;
	private LocalDateTime fechaCreacion;

	public Cliente(Long id, String nombre, String cedula, LocalDateTime fechaCreacion) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
		validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

		this.id = id;
		this.nombre = nombre;
		this.cedula = cedula;
		this.fechaCreacion = fechaCreacion;
	}

}
