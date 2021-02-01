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

}
