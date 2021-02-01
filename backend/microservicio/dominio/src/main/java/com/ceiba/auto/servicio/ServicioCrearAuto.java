package com.ceiba.auto.servicio;

import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearAuto {

	private static final String EL_AUTO_YA_EXISTE_EN_EL_SISTEMA = "El auto ya existe en el sistema";

	private final RepositorioAuto repositorioAuto;

	public ServicioCrearAuto(RepositorioAuto repositorioAuto) {
		this.repositorioAuto = repositorioAuto;
	}

	public Long ejecutar(Auto auto) {
		validarExistenciaPrevia(auto);
		return this.repositorioAuto.crear(auto);
	}

	private void validarExistenciaPrevia(Auto auto) {
		boolean existe = this.repositorioAuto.existe(auto.getSerial());
		if (existe) {
			throw new ExcepcionDuplicidad(EL_AUTO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
