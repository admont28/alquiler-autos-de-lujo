package com.ceiba.alquiler.adaptador.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoAlquiler implements RowMapper<Alquiler>, MapperResult {
	
	private final RepositorioAuto repositorioAuto;
	private final RepositorioCliente repositorioCliente;
	
	public MapeoAlquiler(RepositorioAuto repositorioAuto, RepositorioCliente repositorioCliente) {
		this.repositorioAuto = repositorioAuto;
		this.repositorioCliente = repositorioCliente;
	}
	
	@Override
	public Alquiler mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		Long autoId = rs.getLong("auto_id");
		Long clienteId = rs.getLong("cliente_id");
		Double subTotal = rs.getDouble("sub_total");
		Double descuento = rs.getDouble("descuento");
		Double total = rs.getDouble("total");
		LocalDate fechaAlquiler = extraerLocalDate(rs, "fecha_alquiler");
		LocalDate fechaDevolucion = extraerLocalDate(rs, "fecha_devolucion");
		LocalDateTime fechaCreacion = extraerLocalDateTime(rs, "fecha_creacion");
		Alquiler alquiler = new Alquiler(id, repositorioAuto.buscar(autoId), repositorioCliente.buscar(clienteId), fechaAlquiler, fechaDevolucion);
		alquiler.setSubTotal(subTotal);
		alquiler.setDescuento(descuento);
		alquiler.setTotal(total);
		alquiler.setFechaCreacion(fechaCreacion);
		return alquiler;
	}

}
