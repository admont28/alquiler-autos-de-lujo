package com.ceiba.cliente.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.io.Serializable;
import java.text.MessageFormat;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cliente implements Serializable{

	private static final long serialVersionUID = 3529047781097396696L;
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente";
	private static final String EL_NOMBRE_DEL_CLIENTE_DEBE_TENER_MINIMO_X_CARACTERES = "El nombre del cliente debe tener mínimo {0} caracteres";
	private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_CLIENTE = "Se debe ingresar el apellido del cliente";
	private static final String EL_APELLIDO_DEL_CLIENTE_DEBE_TENER_MINIMO_X_CARACTERES = "El apellido del cliente debe tener mínimo {0} caracteres";
	private static final String SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE = "Se debe ingresar la dirección del cliente";
	private static final String LA_DIRECCION_DEL_CLIENTE_DEBE_TENER_MINIMO_X_CARACTERES = "La dirección del cliente debe tener mínimo {0} caracteres";
	private static final String SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE = "Se debe ingresar la cédula del cliente";
	private static final String LA_CEDULA_DEL_CLIENTE_DEBE_TENER_MINIMO_X_CARACTERES = "La cédula del cliente debe tener mínimo {0} caracteres";
	
	private static final Integer LONGITUD_MINIMA_NOMBRE = 3;
	private static final Integer LONGITUD_MINIMA_APELLIDO = 3;
	private static final Integer LONGITUD_MINIMA_DIRECCION = 3;
	private static final Integer LONGITUD_MINIMA_CEDULA = 3;

	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String cedula;
	private EstadoCliente estado;
	private LocalDateTime fechaCreacion;

	public Cliente(Long id, String nombre, String apellido, String direccion, String cedula, EstadoCliente estado) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
		validarLongitudMinima(nombre, LONGITUD_MINIMA_NOMBRE, MessageFormat.format(EL_NOMBRE_DEL_CLIENTE_DEBE_TENER_MINIMO_X_CARACTERES, LONGITUD_MINIMA_NOMBRE));
		validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO_DEL_CLIENTE);
		validarLongitudMinima(apellido, LONGITUD_MINIMA_APELLIDO, MessageFormat.format(EL_APELLIDO_DEL_CLIENTE_DEBE_TENER_MINIMO_X_CARACTERES, LONGITUD_MINIMA_APELLIDO));
		validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE);
		validarLongitudMinima(direccion, LONGITUD_MINIMA_DIRECCION, MessageFormat.format(LA_DIRECCION_DEL_CLIENTE_DEBE_TENER_MINIMO_X_CARACTERES, LONGITUD_MINIMA_DIRECCION));
		validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE);
		validarLongitudMinima(cedula, LONGITUD_MINIMA_CEDULA, MessageFormat.format(LA_CEDULA_DEL_CLIENTE_DEBE_TENER_MINIMO_X_CARACTERES, LONGITUD_MINIMA_CEDULA));

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.cedula = cedula;
		this.estado = estado == null ? EstadoCliente.ACTIVO : estado;
		this.fechaCreacion = LocalDateTime.now();
	}
	
	public void cambiarEstadoAEliminado() {
		this.estado = EstadoCliente.ELIMINADO;
	}

}
