package com.ceiba.cliente.adaptador.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoCliente implements RowMapper<Cliente>, MapperResult {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		String direccion = rs.getString("direccion");
		String cedula = rs.getString("cedula");
		EstadoCliente estado = EstadoCliente.valueOf(rs.getString("estado"));
		LocalDateTime fechaCreacion = extraerLocalDateTime(rs, "fecha_creacion");
		return Cliente.builder().id(id).nombre(nombre).apellido(apellido).direccion(direccion).cedula(cedula)
				.estado(estado).fechaCreacion(fechaCreacion).build();
	}

}
