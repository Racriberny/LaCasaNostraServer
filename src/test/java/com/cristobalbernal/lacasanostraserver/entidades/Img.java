package com.cristobalbernal.lacasanostraserver.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Img {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 355)
    private String name;
    @Basic
    @Column(name = "type", nullable = true, length = 255)
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Img img = (Img) o;
        return id == img.id && Objects.equals(name, img.name) && Objects.equals(type, img.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
