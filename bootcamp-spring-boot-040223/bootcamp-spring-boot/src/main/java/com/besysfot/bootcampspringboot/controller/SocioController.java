package com.besysfot.bootcampspringboot.controller;

import com.besysfot.bootcampspringboot.entidades.onetoone.Socio;
import com.besysfot.bootcampspringboot.servicios.interfaces.SocioServicie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socios")
public class SocioController {

    private final SocioServicie servicio;

    public SocioController(SocioServicie servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<?> altaSocio(@RequestBody Socio socio){
        return ResponseEntity.ok(this.servicio.altaSocio(socio));
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        return ResponseEntity.ok(this.servicio.buscarTodos());
    }
}
