package com.cristobalbernal.lacasanostraserver.repo;

import com.cristobalbernal.lacasanostraserver.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductorDao extends JpaRepository<Producto,Integer> {

}
