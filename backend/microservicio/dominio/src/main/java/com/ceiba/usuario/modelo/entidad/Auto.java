package com.ceiba.usuario.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Auto {

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AUTO = "Se debe ingresar el nombre del auto";
	private static final String SE_DEBE_INGRESAR_EL_MODELO_DEL_AUTO = "Se debe ingresar el modelo del auto";
	private static final String SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA_DEL_AUTO = "Se debe ingresar el precio por día del auto";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación del auto";

	private Long id;
	private String nombre;
	private String modelo;
	private Double precioPorDia;
	private LocalDateTime fechaCreacion;

	public Auto(Long id, String nombre, String modelo, Double precioPorDia, LocalDateTime fechaCreacion) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AUTO);
		validarObligatorio(modelo, SE_DEBE_INGRESAR_EL_MODELO_DEL_AUTO);
		validarObligatorio(precioPorDia, SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA_DEL_AUTO);
		validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

		this.id = id;
		this.nombre = nombre;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
		this.fechaCreacion = fechaCreacion;
	}
}
