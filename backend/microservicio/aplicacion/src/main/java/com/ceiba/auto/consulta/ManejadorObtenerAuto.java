package com.ceiba.auto.consulta;

import java.util.List;

import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

@Component
public class ManejadorObtenerAuto {

    private final DaoUsuario daoUsuario;

    public ManejadorObtenerAuto(DaoUsuario daoUsuario){
        this.daoUsuario = daoUsuario;
    }

    public List<DtoUsuario> ejecutar(){ return this.daoUsuario.listar(); }
}
