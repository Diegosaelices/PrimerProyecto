package com.iesjuanbosco.ejemploweb.entity;

import jakarta.persistence.*;

@Entity //indicamos que esta clase es una entidad relacionada con la tabla productos
@Table(name="productos")
public class Producto {

    @Id //indicamos que ese va a ser el id y generamos el valor automaticamente de 1 en 1 con IDENTITY
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer cantidad;
    private Double precio;

    public Producto( Long id, String titulo, Integer cantidad, Double precio ) {

        this.id = id;
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.precio = precio;

    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
