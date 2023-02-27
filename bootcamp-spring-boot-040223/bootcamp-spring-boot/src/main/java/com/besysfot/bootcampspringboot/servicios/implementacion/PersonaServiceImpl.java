package com.besysfot.bootcampspringboot.servicios.implementacion;

import com.besysfot.bootcampspringboot.dominio.Persona;
import com.besysfot.bootcampspringboot.repositorios.PersonaRepository;
import com.besysfot.bootcampspringboot.servicios.interfaces.PersonaService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
    Responsabilidad del servicio es contener las reglas de negocio de mi aplicación.
 */

@Service("beanPersona")
@ConditionalOnProperty(prefix = "app", name = "type-bean", havingValue = "memory")
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repository;

    public PersonaServiceImpl(PersonaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Persona altaPersona(Persona persona) {

        Optional<Persona> oPersona = this.repository.buscarPorDni(persona.getDni());

        if(oPersona.isPresent()) {
            return null;
        } /*else {
            persona = this.repository.altaPersona(persona);
        }*/

        return this.repository.altaPersona(persona);
    }

    @Override
    public Optional<Persona> buscarPorDni(String dni) {
        return this.repository.buscarPorDni(dni);
    }

    @Override
    public Iterable<Persona> obtenerTodos() {
        return this.repository.obtenerTodos();
    }

}
