package com.ceiba.auto.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.fabrica.FabricaAuto;
import com.ceiba.auto.servicio.ServicioActualizarAuto;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.modelo.entidad.Auto;

@Component
public class ManejadorActualizarAuto implements ManejadorComando<ComandoAuto> {

	private final FabricaAuto fabricaAuto;
	private final ServicioActualizarAuto servicioActualizarAuto;

	public ManejadorActualizarAuto(FabricaAuto fabricaAuto, ServicioActualizarAuto servicioActualizarAuto) {
		this.fabricaAuto = fabricaAuto;
		this.servicioActualizarAuto = servicioActualizarAuto;
	}

	public void ejecutar(ComandoAuto comandoAuto) {
		Auto auto = this.fabricaAuto.crear(comandoAuto);
		this.servicioActualizarAuto.ejecutar(auto);
	}
}
