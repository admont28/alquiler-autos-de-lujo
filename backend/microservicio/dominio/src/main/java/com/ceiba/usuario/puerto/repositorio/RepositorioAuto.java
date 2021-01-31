package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Auto;

public interface RepositorioAuto {
	
	/**
	 * Permite crear un auto
	 * 
	 * @param auto
	 * @return el id generado
	 */
	Long crear(Auto usuario);

	/**
	 * Permite actualizar un auto
	 * 
	 * @param usuario
	 */
	void actualizar(Auto usuario);

	/**
	 * Permite eliminar un auto por su id
	 * 
	 * @param id
	 */
	void eliminar(Long id);

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
