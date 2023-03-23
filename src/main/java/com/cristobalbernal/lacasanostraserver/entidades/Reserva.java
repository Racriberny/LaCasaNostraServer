package com.cristobalbernal.lacasanostraserver.entidades;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Reserva {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "cantidad", nullable = true, length = 45)
    private String cantidad;
    @Basic
    @Column(name = "fecha", nullable = true)
    private Date fecha;
    @Basic
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        Reserva reserva = (Reserva) o;
        return id == reserva.id && usuarioId == reserva.usuarioId && Objects.equals(cantidad, reserva.cantidad) && Objects.equals(fecha, reserva.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, fecha, usuarioId);
    }
}
