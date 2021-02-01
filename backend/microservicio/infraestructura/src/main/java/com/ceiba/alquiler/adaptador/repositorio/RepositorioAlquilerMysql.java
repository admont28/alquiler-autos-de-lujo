package com.ceiba.alquiler.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrear;
    
    @SqlStatement(namespace="alquiler", value="buscar")
    private static String sqlBuscar;

    public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Alquiler alquiler) {
        return this.customNamedParameterJdbcTemplate.crear(alquiler.toDTO(), sqlCrear);
    }
    
    

}
