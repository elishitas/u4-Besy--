package com.besysfot.bootcampspringboot.repositorios;

import com.besysfot.bootcampspringboot.entidades.onetoone.Socio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface SocioRepository extends CrudRepository<Socio, Long> {

    @Query("select s from Socio s where s.nombre = ?1")
    Optional<Socio> buscarPorNombre(String nombe);
}
