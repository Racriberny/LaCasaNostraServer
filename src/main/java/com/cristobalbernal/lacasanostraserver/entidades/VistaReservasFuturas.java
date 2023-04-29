package com.cristobalbernal.lacasanostraserver.entidades;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "vista_reservas_futuras", schema = "lacasanostra", catalog = "")
public class VistaReservasFuturas {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "cantidad", nullable = true, length = 45)
    private String cantidad;
    @Basic
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Basic
    @Column(name = "fecha", nullable = true)
    private Date fecha;
    @Basic
    @Column(name = "hora", nullable = false)
    private Time hora;

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

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VistaReservasFuturas that = (VistaReservasFuturas) o;
        return id == that.id && usuarioId == that.usuarioId && Objects.equals(cantidad, that.cantidad) && Objects.equals(fecha, that.fecha) && Objects.equals(hora, that.hora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, usuarioId, fecha, hora);
    }
}
