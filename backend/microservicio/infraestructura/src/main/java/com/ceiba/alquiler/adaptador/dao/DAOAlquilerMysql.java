package com.ceiba.alquiler.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.adaptador.mapeo.MapeoDTOAlquiler;
import com.ceiba.alquiler.modelo.dto.DTOAlquiler;
import com.ceiba.alquiler.puerto.dao.DAOAlquiler;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DAOAlquilerMysql implements DAOAlquiler {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="listar")
    private static String sqlListarAlquileres;

    public DAOAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DTOAlquiler> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarAlquileres, new MapeoDTOAlquiler());
    }

}
