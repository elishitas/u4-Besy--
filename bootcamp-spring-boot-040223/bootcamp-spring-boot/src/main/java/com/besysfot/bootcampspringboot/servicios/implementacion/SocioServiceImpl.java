package com.besysfot.bootcampspringboot.servicios.implementacion;

import com.besysfot.bootcampspringboot.entidades.onetoone.Socio;
import com.besysfot.bootcampspringboot.repositorios.SocioRepository;
import com.besysfot.bootcampspringboot.servicios.interfaces.SocioServicie;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocioServiceImpl implements SocioServicie {

    private final SocioRepository repository;

    public SocioServiceImpl(SocioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Socio altaSocio(Socio socio) {
        Optional<Socio> oSocio = this.repository.buscarPorNombre(socio.getNombre());

        if(oSocio.isPresent()){
            throw new RuntimeException("Usuario existente");
        }

        return this.repository.save(socio);
    }

    @Override
    public Optional<Socio> buscarPorId(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Socio> buscarTodos() {
        return this.repository.findAll();
    }
}
