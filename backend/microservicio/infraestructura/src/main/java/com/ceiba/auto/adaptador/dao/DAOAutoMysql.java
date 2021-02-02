package com.ceiba.auto.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.auto.adaptador.mapeo.MapeoDTOAuto;
import com.ceiba.auto.modelo.dto.DTOAuto;
import com.ceiba.auto.puerto.dao.DAOAuto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DAOAutoMysql implements DAOAuto {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="auto", value="listar")
    private static String sqlListarAutos;

    public DAOAutoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DTOAuto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarAutos, new MapeoDTOAuto());
    }

}
