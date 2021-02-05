package com.ceiba.auto.servicio;

import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionNegocio;

public class ServicioActualizarAuto {

	private static final String EL_AUTO_YA_EXISTE_EN_EL_SISTEMA = "El auto ya existe en el sistema";
	private static final String EL_AUTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "El auto que intenta actualizar, no existe en el sistema";

	private final RepositorioAuto repositorioAuto;

	public ServicioActualizarAuto(RepositorioAuto repositorioAuto) {
		this.repositorioAuto = repositorioAuto;
	}

	public void ejecutar(Auto auto) {
		validarExistencia(auto);
		validarExistenciaPrevia(auto);
		this.repositorioAuto.actualizar(auto);
	}

	private void validarExistencia(Auto auto) {
		Auto existe = this.repositorioAuto.buscar(auto.getId());
		if (existe == null) {
			throw new ExcepcionNegocio(EL_AUTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void validarExistenciaPrevia(Auto auto) {
		boolean existe = this.repositorioAuto.existeExcluyendoId(auto.getId(), auto.getSerial());
		if (existe) {
			throw new ExcepcionDuplicidad(EL_AUTO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
