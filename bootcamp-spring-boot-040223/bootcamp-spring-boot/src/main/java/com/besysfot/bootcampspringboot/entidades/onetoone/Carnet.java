package com.besysfot.bootcampspringboot.entidades.onetoone;


import javax.persistence.*;

@Entity
@Table(name = "carnets")
public class Carnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10, nullable = false, unique = true)
    private String numero;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false)
    @JoinColumn(name = "socio_id")
    private Socio socio;
    //private Long idsocio;

    public Carnet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public String toString() {
        return "Carnet{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", socio=" + socio.toString() +
                '}';
    }
}
