package com.ceiba.auto.adaptador.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.auto.modelo.dto.DTOAuto;
import com.ceiba.auto.modelo.entidad.EstadoAuto;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoDTOAuto implements RowMapper<DTOAuto>, MapperResult {
	
	@Override
	public DTOAuto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String serial = rs.getString("serial");
		String nombre = rs.getString("nombre");
		String modelo = rs.getString("modelo");
		Double precioPorDia = rs.getDouble("precio_dia");
		EstadoAuto estado = EstadoAuto.valueOf(rs.getString("estado"));
		LocalDateTime fechaCreacion = extraerLocalDateTime(rs, "fecha_creacion");
		return new DTOAuto(id, serial, nombre, modelo, precioPorDia, estado, fechaCreacion);
	}

}

