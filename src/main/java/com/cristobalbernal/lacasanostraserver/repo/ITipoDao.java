package com.cristobalbernal.lacasanostraserver.repo;

import com.cristobalbernal.lacasanostraserver.entidades.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoDao extends JpaRepository<Tipo,Integer> {
}
