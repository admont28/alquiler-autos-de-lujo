package com.ceiba.dominio.excepcion;

public class ExcepcionNegocio extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionNegocio(String message) {
        super(message);
    }
}
