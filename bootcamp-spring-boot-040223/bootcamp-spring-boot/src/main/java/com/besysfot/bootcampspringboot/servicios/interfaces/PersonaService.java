package com.besysfot.bootcampspringboot.servicios.interfaces;

import com.besysfot.bootcampspringboot.dominio.Persona;

import java.util.Optional;

public interface PersonaService {

    Persona altaPersona(Persona persona);
    Optional<Persona> buscarPorDni(String dni);
    Iterable<Persona> obtenerTodos();


}
