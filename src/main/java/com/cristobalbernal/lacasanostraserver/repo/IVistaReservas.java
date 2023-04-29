package com.cristobalbernal.lacasanostraserver.repo;

import com.cristobalbernal.lacasanostraserver.entidades.VistaReservasFuturas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVistaReservas extends JpaRepository<VistaReservasFuturas,Integer> {
}
