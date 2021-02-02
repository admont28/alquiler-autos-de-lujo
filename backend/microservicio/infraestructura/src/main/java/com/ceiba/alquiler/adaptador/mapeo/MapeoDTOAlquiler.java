package com.ceiba.alquiler.adaptador.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.alquiler.modelo.dto.DTOAlquiler;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoDTOAlquiler implements RowMapper<DTOAlquiler>, MapperResult {

	@Override
	public DTOAlquiler mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		Long autoId = rs.getLong("auto_id");
		Long clienteId = rs.getLong("cliente_id");
		Double subTotal = rs.getDouble("sub_total");
		Double descuento = rs.getDouble("descuento");
		Double total = rs.getDouble("total");
		LocalDate fechaAlquiler = extraerLocalDate(rs, "fecha_alquiler");
		LocalDate fechaDevolucion = extraerLocalDate(rs, "fecha_devolucion");
		LocalDateTime fechaCreacion = extraerLocalDateTime(rs, "fecha_creacion");
		return new DTOAlquiler(id, autoId, clienteId, subTotal, descuento, total, fechaAlquiler, fechaDevolucion, fechaCreacion);
	}

}
