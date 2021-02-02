package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;

public class ServicioCrearAlquiler {
	
	private final RepositorioAlquiler repositorioAlquiler;

	public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
		this.repositorioAlquiler = repositorioAlquiler;
	}

	public Long ejecutar(Alquiler alquiler) {		
		alquiler.validarFechaCreacionLunesAViernes();
		alquiler.validarEstadoDisponibleAuto();
		alquiler.validarEstadoActivoCliente();
		
		alquiler.calcularSubTotal();
		alquiler.calcularDescuentos();
		alquiler.calcularTotal();

		Long id = this.repositorioAlquiler.crear(alquiler);
		
		alquiler.getAuto().cambiarEstadoAutoAlquilado();
		
		return id;
	}
	
}
