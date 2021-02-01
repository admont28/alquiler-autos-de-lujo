package com.ceiba.alquiler.comando;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAlquiler{

    private Long id;
    private Long autoId;
    private Long clienteId;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
}
