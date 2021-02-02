package com.ceiba.auto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAuto {

	private Long id;
	private String serial;
	private String nombre;
	private String modelo;
	private Double precioPorDia;
}
