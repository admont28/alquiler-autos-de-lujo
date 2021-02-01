package com.ceiba.auto.puerto.dao;

import com.ceiba.auto.modelo.entidad.Auto;

public interface DaoAuto {

    /**
     * Permite obtener un auto
     * @return el auto
     */
    Auto obtener(Long id);
}
