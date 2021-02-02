package com.ceiba.auto.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.auto.modelo.dto.DTOAuto;
import com.ceiba.auto.puerto.dao.DaoAuto;

@Component
public class ManejadorObtenerAuto {

    private final DaoAuto daoAuto;

    public ManejadorObtenerAuto(DaoAuto daoAuto){
        this.daoAuto = daoAuto;
    }

    public List<DTOAuto> ejecutar(){ return this.daoAuto.listar(); }
}
