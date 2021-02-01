package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface DaoCliente {

    /**
     * Permite obtener un cliente
     * @return el cliente
     */
    Cliente obtener(Long id);
}
