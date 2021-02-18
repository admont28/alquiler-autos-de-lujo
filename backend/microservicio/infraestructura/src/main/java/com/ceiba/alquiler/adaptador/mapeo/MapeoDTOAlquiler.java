package com.ceiba.alquiler.adaptador.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.alquiler.modelo.dto.DTOAlquiler;
import com.ceiba.auto.modelo.dto.DTOAuto;
import com.ceiba.auto.modelo.entidad.EstadoAuto;
import com.ceiba.cliente.modelo.dto.DTOCliente;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoDTOAlquiler implements RowMapper<DTOAlquiler>, MapperResult {

	@Override
	public DTOAlquiler mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Auto
		Long autoId = rs.getLong("auto_id");
		String autoSerial = rs.getString("auto_serial");
		String autoNombre = rs.getString("auto_nombre");
		String autoModelo = rs.getString("auto_modelo");
		Double autoPrecioPorDia = rs.getDouble("auto_precio_dia");
		EstadoAuto autoEstado = EstadoAuto.valueOf(rs.getString("auto_estado"));
		String autoUrlImagen = rs.getString("auto_url_imagen");
		LocalDateTime autoFechaCreacion = extraerLocalDateTime(rs, "auto_fecha_creacion");
		DTOAuto auto = new DTOAuto(autoId, autoSerial, autoNombre, autoModelo, autoPrecioPorDia, autoEstado, autoUrlImagen, autoFechaCreacion);
		
		// Cliente
		Long clienteId = rs.getLong("cliente_id");
		String clienteNombre = rs.getString("cliente_nombre");
		String clienteApellido = rs.getString("cliente_apellido");
		String clienteDireccion = rs.getString("cliente_direccion");
		String clienteCedula = rs.getString("cliente_cedula");
		EstadoCliente clientEestado = EstadoCliente.valueOf(rs.getString("cliente_estado"));
		LocalDateTime clienteFechaCreacion = extraerLocalDateTime(rs, "cliente_fecha_creacion");
		DTOCliente cliente = new DTOCliente(clienteId, clienteNombre, clienteApellido, clienteDireccion, clienteCedula, clientEestado, clienteFechaCreacion);
		
		// Alquiler
		Long id = rs.getLong("alquiler_id");
		Double subTotal = rs.getDouble("alquiler_sub_total");
		Double descuento = rs.getDouble("alquiler_descuento");
		Double total = rs.getDouble("alquiler_total");
		LocalDate fechaAlquiler = extraerLocalDate(rs, "alquiler_fecha_alquiler");
		LocalDate fechaDevolucion = extraerLocalDate(rs, "alquiler_fecha_devolucion");
		LocalDateTime fechaCreacion = extraerLocalDateTime(rs, "alquiler_fecha_creacion");
		return new DTOAlquiler(id, auto, cliente, subTotal, descuento, total, fechaAlquiler, fechaDevolucion, fechaCreacion);
	}

}
