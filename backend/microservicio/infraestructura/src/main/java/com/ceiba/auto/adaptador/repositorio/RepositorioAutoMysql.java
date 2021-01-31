package com.ceiba.auto.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Auto;
import com.ceiba.usuario.puerto.repositorio.RepositorioAuto;

@Repository
public class RepositorioAutoMysql implements RepositorioAuto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="auto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="auto", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="auto", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="auto", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="usuario", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioAutoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Auto auto) {
        return this.customNamedParameterJdbcTemplate.crear(auto, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String serial) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("serial", serial);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Auto auto) {
        this.customNamedParameterJdbcTemplate.actualizar(auto, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String serial) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("serial", serial);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
