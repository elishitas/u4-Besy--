package com.besysfot.bootcampspringboot.repositorios;

import com.besysfot.bootcampspringboot.dominio.Persona;

import java.util.Optional;

/*
    Responsabilidad de los repositorio es el acceso a datos independientemente de donde se encuentren alojados
 */
public interface PersonaRepository {

    Persona altaPersona(Persona persona);
    Optional<Persona> buscarPorDni(String dni);
    Optional<Persona> buscarPorId(Long id);
    Iterable<Persona> obtenerTodos();

}
