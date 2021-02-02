package com.ceiba.auto.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.auto.adaptador.mapeo.MapeoAuto;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioAutoMysql implements RepositorioAuto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="auto", value="crear")
    private static String sqlCrearAuto;
    
    @SqlStatement(namespace="auto", value="buscar")
    private static String sqlBuscarAuto;

    @SqlStatement(namespace="auto", value="actualizar")
    private static String sqlActualizarAuto;
    
    @SqlStatement(namespace="auto", value="existe")
    private static String sqlExisteAuto;

    @SqlStatement(namespace="auto", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoIdAuto;

    public RepositorioAutoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Auto auto) {
        return this.customNamedParameterJdbcTemplate.crear(auto, sqlCrearAuto);
    }
    
    @Override
	public Auto buscar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarAuto, paramSource, new MapeoAuto());
	}

    @Override
    public boolean existe(String serial) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("serial", serial);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteAuto,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Auto auto) {
        this.customNamedParameterJdbcTemplate.actualizar(auto, sqlActualizarAuto);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String serial) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("serial", serial);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdAuto,paramSource, Boolean.class);
    }

}
