package com.besysfot.bootcampspringboot.controller;

import com.besysfot.bootcampspringboot.entidades.manytoone.Marca;
import com.besysfot.bootcampspringboot.repositorios.MarcaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaRepository repository;


    public MarcaController(MarcaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Marca altaMarca(@RequestBody Marca marca){
        return this.repository.save(marca);
    }

    @GetMapping("/paginado")
    public Page<Marca> paginado(Pageable pageable){
        return this.repository.findAll(pageable);
    }

}
