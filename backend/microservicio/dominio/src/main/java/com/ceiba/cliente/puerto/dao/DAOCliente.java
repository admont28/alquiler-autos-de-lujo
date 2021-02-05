package com.ceiba.cliente.puerto.dao;

import java.util.List;

import com.ceiba.cliente.modelo.dto.DTOCliente;

public interface DAOCliente {

	/**
	 * Permite listar los clientes
	 * 
	 * @return los clientes
	 */
	List<DTOCliente> listar();
}