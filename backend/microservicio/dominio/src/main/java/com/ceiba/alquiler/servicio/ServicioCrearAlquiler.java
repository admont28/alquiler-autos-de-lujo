package com.ceiba.alquiler.servicio;

import java.util.Calendar;

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
	private static final String SOLO_SE_PERMITE_CREAR_EL_ALQUILER_DE_LUNES_A_VIERNES = "Solo se permite crear el alquiler de Lunes a Viernes";
	
	private static final int CANTIDAD_DIAS_PARA_OBTENER_DESCUENTO = 15;
	private static final int[] DIAS_DEL_MES_PARA_OBTENER_DESCUENTO = {1, 2, 3, 4, 5};
	// Descuento del 5%
	private static final double PORCENTAJE_DESCUENTO_POR_CANTIDAD_DE_DIAS_DE_ALQUILER = 0.05;
	// Descuento del 3%
	private static final double PORCENTAJE_DESCUENTO_POR_DIA_DEL_MES_DEL_ALQUILER = 0.03;

	private final RepositorioAlquiler repositorioAlquiler;

	public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
		this.repositorioAlquiler = repositorioAlquiler;
	}

	public Long ejecutar(Alquiler alquiler, Auto auto, Cliente cliente) {
		alquiler.asignarAuto(auto);
		alquiler.asignarCliente(cliente);
		
		validarFechaCreacionAlquilerLunesAViernes();
		validarEstadoDisponibleAuto(alquiler.getAuto());
		validarEstadoActivoCliente(alquiler.getCliente());
		
		alquiler.calcularSubTotal(auto.getPrecioPorDia());
		alquiler.calcularDescuentos(CANTIDAD_DIAS_PARA_OBTENER_DESCUENTO, DIAS_DEL_MES_PARA_OBTENER_DESCUENTO, PORCENTAJE_DESCUENTO_POR_CANTIDAD_DE_DIAS_DE_ALQUILER, PORCENTAJE_DESCUENTO_POR_DIA_DEL_MES_DEL_ALQUILER);
		alquiler.calcularTotal();

		Long id = this.repositorioAlquiler.crear(alquiler);
		
		auto.cambiarEstadoAutoAlquilado();
		
		return id;
	}
	
	private void validarFechaCreacionAlquilerLunesAViernes() {
		switch (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SATURDAY:
			case Calendar.SUNDAY:
				throw new ExcepcionNegocio(SOLO_SE_PERMITE_CREAR_EL_ALQUILER_DE_LUNES_A_VIERNES);
			default:
				break;
		}
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
