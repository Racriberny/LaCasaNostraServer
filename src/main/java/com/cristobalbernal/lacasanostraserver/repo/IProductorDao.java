package com.cristobalbernal.lacasanostraserver.repo;

import com.cristobalbernal.lacasanostraserver.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface IProductorDao extends JpaRepository<Producto,Integer> {

    @Query(value="SELECT p FROM Producto p WHERE p.tipoIdTipo = ?1")
    List<Producto> getProductoByTipo(int id);

}
