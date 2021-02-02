package com.ceiba.alquiler.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.modelo.dto.DTOAlquiler;
import com.ceiba.alquiler.puerto.dao.DAOAlquiler;

@Component
public class ManejadorListarAlquiler {

	private final DAOAlquiler daoAlquiler;

	public ManejadorListarAlquiler(DAOAlquiler daoAlquiler) {
		this.daoAlquiler = daoAlquiler;
	}

	public List<DTOAlquiler> ejecutar() {
		return this.daoAlquiler.listar();
	}
}
