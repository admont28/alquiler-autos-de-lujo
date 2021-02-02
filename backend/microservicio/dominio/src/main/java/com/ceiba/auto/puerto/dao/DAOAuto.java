package com.ceiba.auto.puerto.dao;

import java.util.List;

import com.ceiba.auto.modelo.dto.DTOAuto;

public interface DAOAuto {

	/**
	 * Permite obtener todos los autos
	 * 
	 * @return los autos
	 */
	List<DTOAuto> listar();
}
