package com.cristobalbernal.lacasanostraserver.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Tipo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 300)
    private String descripcion;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo = (Tipo) o;
        return id == tipo.id && Objects.equals(nombre, tipo.nombre) && Objects.equals(descripcion, tipo.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion);
    }
}
