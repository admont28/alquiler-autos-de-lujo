package com.ceiba.cliente.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.cliente.adaptador.mapeo.MapeoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="crear")
    private static String sqlCrearCliente;
    
    @SqlStatement(namespace="cliente", value="buscar")
    private static String sqlBuscarCliente;

    @SqlStatement(namespace="cliente", value="actualizar")
    private static String sqlActualizarCliente;

    @SqlStatement(namespace="cliente", value="existe")
    private static String sqlExisteCliente;

    @SqlStatement(namespace="cliente", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoIdCliente;

    public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Cliente cliente) {
        return this.customNamedParameterJdbcTemplate.crear(cliente, sqlCrearCliente);
    }
    
    @Override
	public Cliente buscar(Long id) {
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarCliente, paramSource, new MapeoCliente());
	}
    
    @Override
    public void actualizar(Cliente cliente) {
        this.customNamedParameterJdbcTemplate.actualizar(cliente, sqlActualizarCliente);
    }

    @Override
    public boolean existe(String cedula) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cedula", cedula);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCliente,paramSource, Boolean.class);
    }


    @Override
    public boolean existeExcluyendoId(Long id, String cedula) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("cedula", cedula);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdCliente,paramSource, Boolean.class);
    }

	

}
