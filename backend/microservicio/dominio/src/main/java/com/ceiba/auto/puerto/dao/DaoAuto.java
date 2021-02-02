package com.ceiba.auto.puerto.dao;

import java.util.List;

import com.ceiba.auto.modelo.dto.DTOAuto;

public interface DaoAuto {

    /**
     * Permite obtener todos los autos
     * @return el auto
     */
	List<DTOAuto> listar();
}
