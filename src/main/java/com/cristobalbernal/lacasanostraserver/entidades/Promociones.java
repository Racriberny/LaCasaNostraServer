package com.cristobalbernal.lacasanostraserver.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Promociones {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "Validado", nullable = true)
    private Byte validado;
    @Basic
    @Column(name = "Usuario_id", nullable = false)
    private int usuarioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getValidado() {
        return validado;
    }

    public void setValidado(Byte validado) {
        this.validado = validado;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promociones that = (Promociones) o;
        return id == that.id && usuarioId == that.usuarioId && Objects.equals(validado, that.validado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, validado, usuarioId);
    }
}
