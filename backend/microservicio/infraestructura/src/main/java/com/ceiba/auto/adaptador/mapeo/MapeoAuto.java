package com.ceiba.auto.adaptador.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.modelo.entidad.EstadoAuto;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoAuto implements RowMapper<Auto>, MapperResult {
	
	@Override
	public Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String serial = rs.getString("serial");
		String nombre = rs.getString("nombre");
		String modelo = rs.getString("modelo");
		Double precioPorDia = rs.getDouble("precio_dia");
		EstadoAuto estado = EstadoAuto.valueOf(rs.getString("estado"));
		LocalDateTime fechaCreacion = extraerLocalDateTime(rs, "fecha_creacion");
		String imagen = rs.getString("url_imagen");
		Auto auto = new Auto(id, serial, nombre, modelo, precioPorDia, estado, imagen);
		auto.setFechaCreacion(fechaCreacion);
		return auto;
	}

}
