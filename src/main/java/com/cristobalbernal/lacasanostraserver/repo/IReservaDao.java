package com.cristobalbernal.lacasanostraserver.repo;

import com.cristobalbernal.lacasanostraserver.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaDao extends JpaRepository<Reserva,Integer> {
}
