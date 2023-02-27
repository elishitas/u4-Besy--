package com.besysfot.bootcampspringboot.controller;

import com.besysfot.bootcampspringboot.dominio.Persona;
import com.besysfot.bootcampspringboot.servicios.interfaces.PersonaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    /*@Autowired
    //@Qualifier("personaServiceImplEmpty")
    private PersonaService service;*/

    /*
    NO ES BUENA PRACTICA
    @Autowired
    private PersonaServiceImplEmpty serviceEmpty;
    */

    /*
        INYECCION POR CONSTRUCTOR
     */

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Persona> obtenerTodos(){
        /* Arrays.asList reemplaza estas lineas
        listaPersonas.add(new Persona());
        listaPersonas.add(new Persona());
        listaPersonas.add(new Persona());
        listaPersonas.add(new Persona());
        */
        return (List<Persona>) this.service.obtenerTodos();

    }

    @GetMapping("/{id}")
    public Persona busarPorId(@PathVariable Long id){
        return ((List<Persona>)this.service.obtenerTodos()).
                stream().
                filter(persona -> persona.getId() == id).
                findAny().
                orElse(new Persona());

        /*for(Persona persona : listaPersonas) {
            if(persona.getId() == id) {
                return persona;
            }
        }*/
    }


    /*public Persona altaPersona(@RequestBody Persona persona){
        //Agregar validaciones programaticas
        persona.setId((long) (this.listaPersonas.size()+1));
        this.listaPersonas.add(persona);
        return persona;
    }*/

    @PostMapping()
    public ResponseEntity<Persona> altaPersona(@RequestBody Persona persona) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("app-info", "contacto@bootcamp.com");

        /*if(this.isDniExist(persona.getDni())){
            return ResponseEntity.badRequest().body("Dni Existente");
        }

        persona.setId((long) (this.listaPersonas.size()+1));
        this.listaPersonas.add(persona);*/
        Persona personaAdd = this.service.altaPersona(persona);

        //Manejo del objeto nulo informando que existe la persona.

        return new ResponseEntity<Persona>(personaAdd, headers, HttpStatus.CREATED);

        /*return ResponseEntity.
                status(HttpStatus.CREATED).
                body(persona);*/
    }


    /*public Persona updatePersona(@PathVariable Long id,
                                 @RequestBody Persona persona){
        Optional<Persona> oPersona = this.listaPersonas.stream().
                filter(p -> p.getId() == id)
                .findAny();

        if(!oPersona.isPresent()){
            throw new RuntimeException("El Id ingresado no existe");
        }

        this.listaPersonas.forEach(p -> {
            if(p.getId() == id){
                p.setNombre(persona.getNombre());
                p.setApellido(persona.getApellido());
            }
        } );

        return persona;
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable Long id,
                                 @RequestBody Persona persona){

        Map<String, Object> mensajeBody = new HashMap<>();

        /*Optional<Persona> oPersona = this.listaPersonas.stream().
                filter(p -> p.getId() == id)
                .findAny();

        if(!oPersona.isPresent()){
            mensajeBody.put("success", Boolean.FALSE);
            mensajeBody.put("mensaje", String.
                    format("El ID %d ingresado no existe", id));
            return ResponseEntity.
                    badRequest().
                    body(mensajeBody);
                    *//*body(String.
                            format("El ID %d ingresado no existe", id)
                    );*//*
        }

        this.listaPersonas.forEach(p -> {
            if(p.getId() == id){
                p.setNombre(persona.getNombre());
                p.setApellido(persona.getApellido());
            }
        } );

        int indice = (int) (id - 1);

        mensajeBody.put("success", Boolean.TRUE);
        mensajeBody.put("data", this.listaPersonas.get(indice));*/

        return ResponseEntity.ok(mensajeBody);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id){
        int indice = (int) (id - 1L);
        /*System.out.println("ID: " + id);
        System.out.println("Indice: " + indice);*/
        //this.listaPersonas.remove(indice);
    }


    /*private boolean isDniExist(String dni){
        Optional<Persona> persona = this.listaPersonas
                .stream()
                .filter(per -> per.getDni().equals(dni.trim()))
                .findAny();

        return persona.isPresent();
    }*/

}
