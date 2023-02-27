package com.besysfot.bootcampspringboot.controller;

import com.besysfot.bootcampspringboot.entidades.onetoone.Carnet;
import com.besysfot.bootcampspringboot.repositorios.CarnetReposiory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carnets")
public class CarnetController {

    private final CarnetReposiory reposiory;

    public CarnetController(CarnetReposiory reposiory) {
        this.reposiory = reposiory;
    }

    @PostMapping
    public Carnet altaCarnet(@RequestBody Carnet carnet){
        System.out.println(carnet.toString());
        return this.reposiory.save(carnet);
    }
}
