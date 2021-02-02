package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioEliminarCliente {

	private final RepositorioCliente repositorioCliente;

	public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}

	public void ejecutar(Cliente cliente) {
		cliente.cambiarEstadoAEliminado();
		this.repositorioCliente.actualizar(cliente);
	}
}
