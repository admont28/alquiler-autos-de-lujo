package com.ceiba.auto.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.auto.adaptador.mapeo.MapeoDTOAuto;
import com.ceiba.auto.modelo.dto.DTOAuto;
import com.ceiba.auto.puerto.dao.DaoAuto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoAutoMysql implements DaoAuto {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="auto", value="listar")
    private static String sqlListar;

    public DaoAutoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DTOAuto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDTOAuto());
    }

}
