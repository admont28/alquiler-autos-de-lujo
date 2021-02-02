package com.ceiba.alquiler.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.adaptador.mapeo.MapeoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final RepositorioAuto repositorioAuto;
	private final RepositorioCliente repositorioCliente;
	
	public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, RepositorioAuto repositorioAuto, RepositorioCliente repositorioCliente) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
		this.repositorioAuto = repositorioAuto;
		this.repositorioCliente = repositorioCliente;
	}

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrearAlquiler;
    
    @SqlStatement(namespace="alquiler", value="buscar")
    private static String sqlBuscarAlquiler;

    @Override
    public Long crear(Alquiler alquiler) {
        return this.customNamedParameterJdbcTemplate.crear(alquiler.convertirADTO(), sqlCrearAlquiler);
    }
    
    @Override
	public Alquiler buscar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarAlquiler, paramSource, new MapeoAlquiler(repositorioAuto, repositorioCliente));
	}
    

}
