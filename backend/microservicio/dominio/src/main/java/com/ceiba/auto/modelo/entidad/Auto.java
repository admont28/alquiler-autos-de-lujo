package com.ceiba.auto.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

import java.text.MessageFormat;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Auto {

	private static final String SE_DEBE_INGRESAR_EL_SERIAL_DEL_AUTO = "Se debe ingresar el serial del auto";
	private static final String EL_SERIAL_DEBE_TENER_MINIMO_X_CARACTERES = "El serial debe tener mínimo {0} caracteres";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AUTO = "Se debe ingresar el nombre del auto";
	private static final String EL_NOMBRE_DEBE_TENER_MINIMO_X_CARACTERES = "El nombre debe tener mínimo {0} caracteres";
	private static final String SE_DEBE_INGRESAR_EL_MODELO_DEL_AUTO = "Se debe ingresar el modelo del auto";
	private static final String EL_MODELO_DEBE_TENER_MINIMO_X_CARACTERES = "El modelo debe tener mínimo {0} caracteres";
	private static final String SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA_DEL_AUTO = "Se debe ingresar el precio por día del auto";
	private static final String EL_PRECIO_POR_DIA_DEL_AUTO_DEBE_SER_UN_VALOR_POSITIVO = "El precio por día del auto debe ser un valor positivo";
	
	private static final Integer LONGITUD_MINIMA_SERIAL = 3;
	private static final Integer LONGITUD_MINIMA_NOMBRE = 3;
	private static final Integer LONGITUD_MINIMA_MODELO = 3;

	private Long id;
	private String serial;
	private String nombre;
	private String modelo;
	private Double precioPorDia;
	private EstadoAuto estado;
	private LocalDateTime fechaCreacion;

	public Auto(Long id, String serial, String nombre, String modelo, Double precioPorDia, EstadoAuto estado) {
		validarObligatorio(serial, SE_DEBE_INGRESAR_EL_SERIAL_DEL_AUTO);
		validarLongitudMinima(serial, LONGITUD_MINIMA_SERIAL, MessageFormat.format(EL_SERIAL_DEBE_TENER_MINIMO_X_CARACTERES, LONGITUD_MINIMA_SERIAL));
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AUTO);
		validarLongitudMinima(nombre, LONGITUD_MINIMA_NOMBRE, MessageFormat.format(EL_NOMBRE_DEBE_TENER_MINIMO_X_CARACTERES, LONGITUD_MINIMA_NOMBRE));
		validarObligatorio(modelo, SE_DEBE_INGRESAR_EL_MODELO_DEL_AUTO);
		validarLongitudMinima(modelo, LONGITUD_MINIMA_MODELO, MessageFormat.format(EL_MODELO_DEBE_TENER_MINIMO_X_CARACTERES, LONGITUD_MINIMA_MODELO));
		validarObligatorio(precioPorDia, SE_DEBE_INGRESAR_EL_PRECIO_POR_DIA_DEL_AUTO);
		validarPositivo(precioPorDia, EL_PRECIO_POR_DIA_DEL_AUTO_DEBE_SER_UN_VALOR_POSITIVO);

		this.id = id;
		this.serial = serial;
		this.nombre = nombre;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
		this.estado = estado != null ? estado : EstadoAuto.DISPONIBLE;
		this.fechaCreacion = LocalDateTime.now();
	}
	
	public void cambiarEstadoAutoAlquilado() {
		this.estado = EstadoAuto.ALQUILADO;
	}
}
