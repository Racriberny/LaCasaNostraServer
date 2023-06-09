package com.cristobalbernal.lacasanostraserver.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellidos", nullable = true, length = 45)
    private String apellidos;
    @Basic
    @Column(name = "correo_electronico", nullable = true, length = 100)
    private String correoElectronico;
    @Basic
    @Column(name = "contrasena", nullable = true, length = 120)
    private String contrasena;
    @Basic
    @Column(name = "admin", nullable = true)
    private Byte admin;
    @Basic
    @Column(name = "imagen", nullable = true, length = -1)
    private String imagen;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Byte getAdmin() {
        return admin;
    }

    public void setAdmin(Byte admin) {
        this.admin = admin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(correoElectronico, usuario.correoElectronico) && Objects.equals(contrasena, usuario.contrasena) && Objects.equals(admin, usuario.admin) && Objects.equals(imagen, usuario.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, correoElectronico, contrasena, admin, imagen);
    }
}
