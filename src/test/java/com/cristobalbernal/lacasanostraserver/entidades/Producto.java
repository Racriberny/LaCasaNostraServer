package com.cristobalbernal.lacasanostraserver.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Producto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;
    @Basic
    @Column(name = "precio", nullable = true, length = 45)
    private String precio;
    @Basic
    @Column(name = "ingredientees", nullable = true, length = 300)
    private String ingredientees;
    @Basic
    @Column(name = "calorias", nullable = true, length = 45)
    private String calorias;
    @Basic
    @Column(name = "Tipo_idTipo", nullable = false)
    private int tipoIdTipo;
    @Basic
    @Column(name = "img_id", nullable = false)
    private int imgId;
    @Basic
    @Column(name = "tipo_idtipo", nullable = false)
    private int tipoIdtipo;
    @Basic
    @Column(name = "urlImagen", nullable = false, length = 300)
    private String urlImagen;

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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getIngredientees() {
        return ingredientees;
    }

    public void setIngredientees(String ingredientees) {
        this.ingredientees = ingredientees;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public int getTipoIdTipo() {
        return tipoIdTipo;
    }

    public void setTipoIdTipo(int tipoIdTipo) {
        this.tipoIdTipo = tipoIdTipo;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && tipoIdTipo == producto.tipoIdTipo && imgId == producto.imgId && Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio) && Objects.equals(ingredientees, producto.ingredientees) && Objects.equals(calorias, producto.calorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, ingredientees, calorias, tipoIdTipo, imgId);
    }

    public int getTipoIdtipo() {
        return tipoIdtipo;
    }

    public void setTipoIdtipo(int tipoIdtipo) {
        this.tipoIdtipo = tipoIdtipo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
