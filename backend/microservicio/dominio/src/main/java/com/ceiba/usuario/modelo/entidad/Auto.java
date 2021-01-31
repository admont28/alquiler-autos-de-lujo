package com.ceiba.usuario.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Auto {

	private static final String SE_DEBE_INGRESAR_EL_SERIAL_DEL_AUTO = "Se debe ingresar el serial del auto";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AUTO = "Se debe ingresar el nombre del auto";
	private static final String SE_DEBE_INGRESAR_EL_MODELO_DEL_AUTO = "Se debe ingresar el modelo del auto";
	private static final String SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA_DEL_AUTO = "Se debe ingresar el precio por d�a del auto";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creaci�n del auto";

	private Long id;
	private String serial;
	private String nombre;
	private String modelo;
	private Double precioPorDia;
	private EstadoAuto estado;
	private LocalDateTime fechaCreacion;

	public Auto(Long id, String serial, String nombre, String modelo, Double precioPorDia, EstadoAuto estado, LocalDateTime fechaCreacion) {
		validarObligatorio(serial, SE_DEBE_INGRESAR_EL_SERIAL_DEL_AUTO);
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AUTO);
		validarObligatorio(modelo, SE_DEBE_INGRESAR_EL_MODELO_DEL_AUTO);
		validarObligatorio(precioPorDia, SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA_DEL_AUTO);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

		this.id = id;
		this.serial = serial;
		this.nombre = nombre;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
	}
}
