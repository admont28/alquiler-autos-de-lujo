package com.ceiba.cliente.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final ServicioEliminarCliente servicioEliminarCliente;
    private final RepositorioCliente repositorioCliente;

    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente, RepositorioCliente repositorioCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
		this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Long id) {
    	Cliente cliente = repositorioCliente.buscar(id);
        this.servicioEliminarCliente.ejecutar(cliente);
    }
}
