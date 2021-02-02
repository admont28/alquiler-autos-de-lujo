package com.ceiba.alquiler.puerto.dao;

import java.util.List;

import com.ceiba.alquiler.modelo.dto.DTOAlquiler;

public interface DAOAlquiler {

	/**
	 * Permite obtener todos los alquileres
	 * 
	 * @return los alquileres
	 */
	List<DTOAlquiler> listar();
}
