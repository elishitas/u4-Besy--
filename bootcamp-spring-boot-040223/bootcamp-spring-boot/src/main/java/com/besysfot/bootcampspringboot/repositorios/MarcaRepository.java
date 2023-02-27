package com.besysfot.bootcampspringboot.repositorios;

import com.besysfot.bootcampspringboot.entidades.manytoone.Marca;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MarcaRepository extends PagingAndSortingRepository<Marca, Long> {

}
