package com.ceiba.alquiler.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
    	paramSource.addValue("autoId", alquiler.getAuto().getId());
    	paramSource.addValue("clienteId", alquiler.getCliente().getId());
    	paramSource.addValue("subTotal", alquiler.getSubTotal());
    	paramSource.addValue("descuento", alquiler.getDescuento());
    	paramSource.addValue("total", alquiler.getTotal());
    	paramSource.addValue("fechaAlquiler", alquiler.getFechaAlquiler());
    	paramSource.addValue("fechaDevolucion", alquiler.getFechaDevolucion());
    	paramSource.addValue("fechaCreacion", alquiler.getFechaCreacion());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrearAlquiler, paramSource,keyHolder,new String[] { "id" });
		return keyHolder.getKey().longValue();
    }
    
    @Override
	public Alquiler buscar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarAlquiler, paramSource, new MapeoAlquiler());
	}
    

}
