package com.farmacia.farmacia.models;
import javax.persistence.*;

@Entity
@Table(name ="Medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int precio;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "farmacia_id", referencedColumnName = "id")
    private Farmacia farmacia;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
