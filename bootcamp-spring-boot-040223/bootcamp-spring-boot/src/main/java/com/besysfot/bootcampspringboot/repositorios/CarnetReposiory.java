package com.besysfot.bootcampspringboot.repositorios;

import com.besysfot.bootcampspringboot.entidades.onetoone.Carnet;
import org.springframework.data.repository.CrudRepository;

public interface CarnetReposiory extends CrudRepository<Carnet, Long> {


}
