package com.ceiba.cliente.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.adaptador.mapeo.MapeoDTOCliente;
import com.ceiba.cliente.modelo.dto.DTOCliente;
import com.ceiba.cliente.puerto.dao.DAOCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DAOClienteMysql implements DAOCliente {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="listar")
    private static String sqlListarClientes;

    public DAOClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DTOCliente> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarClientes, new MapeoDTOCliente());
    }

}
