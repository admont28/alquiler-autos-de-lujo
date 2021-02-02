package com.ceiba.cliente.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cliente {

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente";
	private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_CLIENTE = "Se debe ingresar el apellido del cliente";
	private static final String SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE = "Se debe ingresar la dirección del cliente";
	private static final String SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE = "Se debe ingresar la cédula del cliente";

	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String cedula;
	private EstadoCliente estado;
	private LocalDateTime fechaCreacion;

	public Cliente(Long id, String nombre, String apellido, String direccion, String cedula) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
		validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO_DEL_CLIENTE);
		validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE);
		validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE);

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.cedula = cedula;
		this.estado = EstadoCliente.ACTIVO;
		this.fechaCreacion = LocalDateTime.now();
	}
	
	public void cambiarEstadoAEliminado() {
		this.estado = EstadoCliente.ELIMINADO;
	}

}
