package com.besysfot.bootcampspringboot.entidades.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "canales")
public class Canal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_canal")
    private String nombre;
    @ManyToMany(mappedBy = "canales",
            fetch = FetchType.LAZY
    )
    private List<Usuario> usuarios;

    public Canal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
