package com.ceiba.cliente.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.dto.DTOCliente;
import com.ceiba.cliente.puerto.dao.DAOCliente;

@Component
public class ManejadorListarCliente {

	private final DAOCliente daoCliente;

	public ManejadorListarCliente(DAOCliente daoAuto) {
		this.daoCliente = daoAuto;
	}

	public List<DTOCliente> ejecutar() {
		return this.daoCliente.listar();
	}
}
