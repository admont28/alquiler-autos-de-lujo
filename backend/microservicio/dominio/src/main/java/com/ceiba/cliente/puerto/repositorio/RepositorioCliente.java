package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {
	
	/**
	 * Permite crear un cliente
	 * 
	 * @param cliente
	 * @return el id generado
	 */
	Long crear(Cliente cliente);
	
	/**
	 * Permite buscar un cliente por su id
	 * 
	 * @param id del cliente
	 * @return el cliente.
	 */
	Cliente buscar(Long id);

	/**
	 * Permite actualizar un cliente
	 * 
	 * @param cliente
	 */
	void actualizar(Cliente cliente);

	/**
	 * Permite validar si existe un cliente con una cedula
	 * 
	 * @param cedula
	 * @return si existe o no
	 */
	boolean existe(String cedula);

	/**
	 * Permite validar si existe un cliente con una cedula excluyendo un id
	 * 
	 * @param decula
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String cedula);

}
