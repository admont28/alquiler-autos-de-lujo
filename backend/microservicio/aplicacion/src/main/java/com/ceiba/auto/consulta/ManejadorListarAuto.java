package com.ceiba.auto.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.auto.modelo.dto.DTOAuto;
import com.ceiba.auto.puerto.dao.DAOAuto;

@Component
public class ManejadorListarAuto {

	private final DAOAuto daoAuto;

	public ManejadorListarAuto(DAOAuto daoAuto) {
		this.daoAuto = daoAuto;
	}

	public List<DTOAuto> ejecutar() {
		return this.daoAuto.listar();
	}
}
