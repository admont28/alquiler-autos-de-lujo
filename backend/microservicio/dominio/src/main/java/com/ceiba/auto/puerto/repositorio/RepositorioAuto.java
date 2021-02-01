package com.ceiba.auto.puerto.repositorio;

import com.ceiba.auto.modelo.entidad.Auto;

public interface RepositorioAuto {
	
	/**
	 * Permite crear un auto
	 * 
	 * @param auto
	 * @return el id generado
	 */
	Long crear(Auto usuario);
	
	/**
	 * Permite buscar un auto por su id
	 * 
	 * @param id del auto
	 * @return el auto.
	 */
	Auto buscar(Long id);

	/**
	 * Permite actualizar un auto
	 * 
	 * @param usuario
	 */
	void actualizar(Auto usuario);

	/**
	 * Permite validar si existe un auto con un serial
	 * 
	 * @param serial
	 * @return si existe o no
	 */
	boolean existe(String serial);

	/**
	 * Permite validar si existe un auto con un serial excluyendo un id
	 * 
	 * @param serial
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String serial);

}
