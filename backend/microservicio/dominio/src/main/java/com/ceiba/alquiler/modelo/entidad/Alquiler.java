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

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Alquiler {

//	private static final String SE_DEBE_INGRESAR_EL_AUTO_DEL_ALQUILER = "Se debe ingresar el auto del alquiler";
//	private static final String SE_DEBE_INGRESAR_EL_CLIENTE_DEL_ALQUILER = "Se debe ingresar el cliente del alquiler";
//	private static final String SE_DEBE_INGRESAR_EL_SUB_TOTAL_DEL_ALQUILER = "Se debe ingresar el sub total del alquiler";
//	private static final String SE_DEBE_INGRESAR_EL_DESCUENTO_DEL_ALQUILER = "Se debe ingresar el descuento del alquiler";
//	private static final String SE_DEBE_INGRESAR_EL_TOTAL_DEL_ALQUILER = "Se debe ingresar el total del alquiler";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DEL_ALQUILER = "Se debe ingresar la fecha de entrega del auto al cliente";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_DEVOLUCION_DEL_ALQUILER = "Se debe ingresar la fecha de devolucion del auto por parte del cliente";
	private static final String LA_FECHA_DEL_ALQUILER_DEBE_SER_MENOR_A_LA_FECHA_DE_DEVOLUCION = "La fecha del alquiler debe ser menor a la fecha de devolución";
	
	
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
//		validarObligatorio(auto, SE_DEBE_INGRESAR_EL_AUTO_DEL_ALQUILER);
//		validarObligatorio(cliente, SE_DEBE_INGRESAR_EL_CLIENTE_DEL_ALQUILER);
//		validarObligatorio(subTotal, SE_DEBE_INGRESAR_EL_SUB_TOTAL_DEL_ALQUILER);
//		validarObligatorio(descuento, SE_DEBE_INGRESAR_EL_DESCUENTO_DEL_ALQUILER);
//		validarObligatorio(total, SE_DEBE_INGRESAR_EL_TOTAL_DEL_ALQUILER);
		validarObligatorio(fechaAlquiler, SE_DEBE_INGRESAR_LA_FECHA_DEL_ALQUILER);
		validarObligatorio(fechaEntrega, SE_DEBE_INGRESAR_LA_FECHA_DE_DEVOLUCION_DEL_ALQUILER);
		validarMenor(fechaAlquiler.atStartOfDay(), fechaEntrega.atStartOfDay(), LA_FECHA_DEL_ALQUILER_DEBE_SER_MENOR_A_LA_FECHA_DE_DEVOLUCION);
		
		this.id = id;
//		this.auto = auto;
//		this.cliente = cliente;
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
	
	public void calcularSubTotal(Double precioPorDia) {
		long diasAlquiler = ChronoUnit.DAYS.between(this.fechaAlquiler, this.fechaDevolucion);
		this.subTotal = precioPorDia * diasAlquiler;
	}
	
	public void calcularDescuentos(int diasParaObtenerDescuento, int[] diasDelMesParaObtenerDescuento, Double porcentajeDescuentoPorCantidadDias, Double porcentajeDescuentoPorDiaDelMes) {
		long diasAlquiler = ChronoUnit.DAYS.between(this.fechaAlquiler, this.fechaDevolucion);
		this.descuento = 0.0;
		
		// Si el alquiler del auto supera los 15 días, el cliente recibirá un descuento del 5% sobre el total del alquiler.
		if (diasAlquiler > diasParaObtenerDescuento) {
			this.descuento += this.subTotal * porcentajeDescuentoPorCantidadDias;
		}
		
		// Si el alquiler del auto se realiza los primeros 5 días de cada mes, el cliente recibirá un descuento adicional del 3% sobre el total del alquiler.
		if (Arrays.stream(diasDelMesParaObtenerDescuento).anyMatch( dia -> dia == this.fechaAlquiler.getDayOfMonth())) {
			this.descuento += this.subTotal * porcentajeDescuentoPorDiaDelMes;
		}
	}
	
	public void calcularTotal() {
		this.total = this.subTotal - this.descuento;
	}
	
	public DTOAlquiler toDTO() {
		Long autoId = auto != null ? auto.getId() : null;
		Long clienteId = cliente != null ? cliente.getId() : null;
		return DTOAlquiler.builder().id(id).autoId(autoId).clienteId(clienteId).subTotal(subTotal).descuento(descuento).total(total).fechaAlquiler(fechaAlquiler).fechaDevolucion(fechaDevolucion).fechaCreacion(fechaCreacion).build();
	}
	
}
