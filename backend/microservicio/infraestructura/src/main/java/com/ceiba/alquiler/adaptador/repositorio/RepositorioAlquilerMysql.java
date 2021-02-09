package com.ceiba.alquiler.adaptador.repositorio;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.adaptador.mapeo.MapeoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrearAlquiler;
    
    @SqlStatement(namespace="alquiler", value="buscar")
    private static String sqlBuscarAlquiler;

    @Override
    public Long crear(Alquiler alquiler) {
		Map<String, Object> extraParams = new LinkedHashMap<>();
		extraParams.put("clienteId", alquiler.getCliente().getId());
		extraParams.put("autoId", alquiler.getAuto().getId());
		return this.customNamedParameterJdbcTemplate.crear(alquiler, sqlCrearAlquiler, extraParams);
    }
    
    @Override
	public Alquiler buscar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarAlquiler, paramSource, new MapeoAlquiler());
	}
    

}
