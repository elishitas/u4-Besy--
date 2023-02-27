package com.besysfot.bootcampspringboot.servicios.interfaces;

import com.besysfot.bootcampspringboot.entidades.onetoone.Socio;

import java.util.Optional;

public interface SocioServicie {

    Socio altaSocio (Socio socio);
    Optional<Socio> buscarPorId(Long id);
    Iterable<Socio> buscarTodos();

}
