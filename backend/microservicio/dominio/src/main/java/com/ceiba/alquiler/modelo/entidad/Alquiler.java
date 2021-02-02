package com.ceiba.alquiler.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import com.ceiba.alquiler.modelo.dto.DTOAlquiler;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.dominio.excepcion.ExcepcionNegocio;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Alquiler {
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DEL_ALQUILER = "Se debe ingresar la fecha de entrega del auto al cliente";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_DEVOLUCION_DEL_ALQUILER = "Se debe ingresar la fecha de devolución del auto por parte del cliente";
	private static final String LA_FECHA_DEL_ALQUILER_DEBE_SER_MENOR_A_LA_FECHA_DE_DEVOLUCION = "La fecha del alquiler debe ser menor a la fecha de devolución";
	private static final String SOLO_SE_PERMITE_CREAR_EL_ALQUILER_DE_LUNES_A_VIERNES = "Solo se permite crear el alquiler de Lunes a Viernes";
	
	private static final int CANTIDAD_DIAS_PARA_OBTENER_DESCUENTO = 15;
	private static final int[] DIAS_DEL_MES_PARA_OBTENER_DESCUENTO = {1, 2, 3, 4, 5};
	// Descuento del 5%
	private static final double PORCENTAJE_DESCUENTO_POR_CANTIDAD_DE_DIAS_DE_ALQUILER = 0.05;
	// Descuento del 3%
	private static final double PORCENTAJE_DESCUENTO_POR_DIA_DEL_MES_DEL_ALQUILER = 0.03;
	
	private Long id;
	private Auto auto;
	private Cliente cliente;
	private Double subTotal;
	private Double descuento;
	private Double total;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private LocalDateTime fechaCreacion;
	
	public Alquiler(Long id, LocalDate fechaAlquiler, LocalDate fechaEntrega) {
		validarObligatorio(fechaAlquiler, SE_DEBE_INGRESAR_LA_FECHA_DEL_ALQUILER);
		validarObligatorio(fechaEntrega, SE_DEBE_INGRESAR_LA_FECHA_DE_DEVOLUCION_DEL_ALQUILER);
		validarMenor(fechaAlquiler.atStartOfDay(), fechaEntrega.atStartOfDay(), LA_FECHA_DEL_ALQUILER_DEBE_SER_MENOR_A_LA_FECHA_DE_DEVOLUCION);
		
		this.id = id;
		this.subTotal = 0.0;
		this.descuento = 0.0;
		this.total = 0.0;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaDevolucion = fechaEntrega;
		this.fechaCreacion = LocalDateTime.now();
	}

	public void asignarAuto(Auto auto) {
		this.auto = auto;
	}

	public void asignarCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void calcularSubTotal() {
		long diasAlquiler = ChronoUnit.DAYS.between(this.fechaAlquiler, this.fechaDevolucion) + 1;
		this.subTotal = this.auto.getPrecioPorDia() * diasAlquiler;
	}
	
	public void calcularDescuentos() {
		long diasAlquiler = ChronoUnit.DAYS.between(this.fechaAlquiler, this.fechaDevolucion) + 1;
		this.descuento = 0.0;
		
		// Si el alquiler del auto supera los 15 d�as, el cliente recibir� un descuento del 5% sobre el total del alquiler.
		if (diasAlquiler > CANTIDAD_DIAS_PARA_OBTENER_DESCUENTO) {
			this.descuento += this.subTotal * PORCENTAJE_DESCUENTO_POR_CANTIDAD_DE_DIAS_DE_ALQUILER;
		}
		
		// Si el alquiler del auto se realiza los primeros 5 d�as de cada mes, el cliente recibir� un descuento adicional del 3% sobre el total del alquiler.
		if (Arrays.stream(DIAS_DEL_MES_PARA_OBTENER_DESCUENTO).anyMatch( dia -> dia == this.fechaCreacion.getDayOfMonth())) {
			this.descuento += this.subTotal * PORCENTAJE_DESCUENTO_POR_DIA_DEL_MES_DEL_ALQUILER;
		}
	}
	
	public void calcularTotal() {
		this.total = this.subTotal - this.descuento;
	}
	
	public void validarFechaCreacionLunesAViernes() {
		switch (this.fechaCreacion.getDayOfWeek()) {
			case SATURDAY:
			case SUNDAY:
				throw new ExcepcionNegocio(SOLO_SE_PERMITE_CREAR_EL_ALQUILER_DE_LUNES_A_VIERNES);
			default:
				break;
		}
	}
	
	public DTOAlquiler toDTO() {
		Long autoId = auto != null ? auto.getId() : null;
		Long clienteId = cliente != null ? cliente.getId() : null;
		return DTOAlquiler.builder().id(id).autoId(autoId).clienteId(clienteId).subTotal(subTotal).descuento(descuento).total(total).fechaAlquiler(fechaAlquiler).fechaDevolucion(fechaDevolucion).fechaCreacion(fechaCreacion).build();
	}
	
}
