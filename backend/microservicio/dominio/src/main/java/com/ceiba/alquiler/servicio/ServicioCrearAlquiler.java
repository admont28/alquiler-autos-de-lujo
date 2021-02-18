package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.jms.EnviarMensaje;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;

public class ServicioCrearAlquiler {
	
	private final RepositorioAlquiler repositorioAlquiler;
	private final EnviarMensaje enviarMensaje;

	public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, EnviarMensaje enviarMensaje) {
		this.repositorioAlquiler = repositorioAlquiler;
		this.enviarMensaje = enviarMensaje;
	}

	public Long ejecutar(Alquiler alquiler) {		
		alquiler.validarFechaCreacionLunesAViernes();
		alquiler.validarEstadoDisponibleAuto();
		alquiler.validarEstadoActivoCliente();
		
		alquiler.calcularSubTotal();
		alquiler.calcularDescuentos();
		alquiler.calcularTotal();

		Long id = this.repositorioAlquiler.crear(alquiler);
		alquiler.setId(id);
		
		alquiler.getAuto().cambiarEstadoAutoAlquilado();
		
		this.enviarMensaje.ejecutar(alquiler);
		
		return alquiler.getId();
	}
	
}
