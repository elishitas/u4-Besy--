package com.besysfot.bootcampspringboot.servicios.implementacion;

import com.besysfot.bootcampspringboot.dominio.Persona;
import com.besysfot.bootcampspringboot.servicios.interfaces.PersonaService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Primary
@ConditionalOnProperty(prefix = "app", name = "type-bean", havingValue = "empty")
public class PersonaServiceImplEmpty implements PersonaService {


    @Override
    public Persona altaPersona(Persona persona) {
        return null;
    }

    @Override
    public Optional<Persona> buscarPorDni(String dni) {
        return Optional.empty();
    }

    @Override
    public Iterable<Persona> obtenerTodos() {
        return null;
    }
}
