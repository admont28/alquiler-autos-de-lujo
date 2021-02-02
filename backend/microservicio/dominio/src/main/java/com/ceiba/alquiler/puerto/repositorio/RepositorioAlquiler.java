package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;

public interface RepositorioAlquiler {
	
	/**
	 * Permite crear un alquiler
	 * 
	 * @param alquiler
	 * @return el id generado
	 */
	Long crear(Alquiler usuario);

	/**
	 * Permite buscar un alquiler por su id.
	 * 
	 * @param id del alquiler
	 * @return el alquiler
	 */
	Alquiler buscar(Long id);

}
