package com.farmacia.farmacia.models;

import javax.persistence.*;

@Entity
@Table(name = "ObraSocial")
public class ObraSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int descuento;

    @ManyToOne
    @JoinColumn(name = "farmacia_id", referencedColumnName = "id")
    private Farmacia farmacia;

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
