package com.besysfot.bootcampspringboot.repositorios;

import com.besysfot.bootcampspringboot.dominio.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepositoryMemory implements PersonaRepository {

    private List<Persona> listaPersonas;

    public PersonaRepositoryMemory() {
        this.listaPersonas = new ArrayList<>(
                Arrays.asList(
                        new Persona(1L, "Mauricio", "Lopez", "1111111"),
                        new Persona(2L, "Mauricio1", "Lopez1", "22222222"),
                        new Persona(3L, "Mauricio2", "Lopez2", "3333333"),
                        new Persona(4L, "Mauricio3", "Lopez3", "4444444")
                )
        );
    }

    @Override
    public Persona altaPersona(Persona persona) {
        persona.setId((long) (this.listaPersonas.size()+1));
        this.listaPersonas.add(persona);
        return persona;
    }

    @Override
    public Optional<Persona> buscarPorDni(String dni) {
        return this.listaPersonas
                .stream()
                .filter(per -> per.getDni().equals(dni.trim()))
                .findAny();
    }

    @Override
    public Optional<Persona> buscarPorId(Long id) {
        return this.listaPersonas
                .stream()
                .filter(per -> per.getId() == id)
                .findAny();
    }

    @Override
    public Iterable<Persona> obtenerTodos() {
        return this.listaPersonas;
    }

}
