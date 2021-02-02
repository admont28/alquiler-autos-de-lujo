package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.modelo.entidad.EstadoAuto;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;
import com.ceiba.dominio.excepcion.ExcepcionNegocio;

public class ServicioCrearAlquiler {

	private static final String EL_AUTO_NO_ESTA_DISPONIBLE_PARA_ALQUILAR = "El auto no está disponible para alquilar";
	private static final String EL_CLIENTE_NO_ESTA_ACTIVO = "El cliente no está activo";

	private final RepositorioAlquiler repositorioAlquiler;

	public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
		this.repositorioAlquiler = repositorioAlquiler;
	}

	public Long ejecutar(Alquiler alquiler, Auto auto, Cliente cliente) {
		alquiler.asignarAuto(auto);
		alquiler.asignarCliente(cliente);
		
		alquiler.validarFechaCreacionLunesAViernes();
		validarEstadoDisponibleAuto(alquiler.getAuto());
		validarEstadoActivoCliente(alquiler.getCliente());
		
		alquiler.calcularSubTotal();
		alquiler.calcularDescuentos();
		alquiler.calcularTotal();

		Long id = this.repositorioAlquiler.crear(alquiler);
		
		auto.cambiarEstadoAutoAlquilado();
		
		return id;
	}
	

	private void validarEstadoDisponibleAuto(Auto auto) {
		if (! EstadoAuto.DISPONIBLE.equals(auto.getEstado())) {
			throw new ExcepcionNegocio(EL_AUTO_NO_ESTA_DISPONIBLE_PARA_ALQUILAR);
		}
	}
	
	private void validarEstadoActivoCliente(Cliente cliente) {
		if (! EstadoCliente.ACTIVO.equals(cliente.getEstado())) {
			throw new ExcepcionNegocio(EL_CLIENTE_NO_ESTA_ACTIVO);
		}
	}
	
	
	
}
