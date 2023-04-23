package com.cristobalbernal.lacasanostraserver.controlers;

import com.cristobalbernal.lacasanostraserver.entidades.Promociones;
import com.cristobalbernal.lacasanostraserver.entidades.Reserva;
import com.cristobalbernal.lacasanostraserver.repo.IPromocionesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promociones")
public class PromocionesController {
    @Autowired
    private IPromocionesDao iPromocionesDao;

    @GetMapping("/all")
    public List<Promociones> getAutores() {
        return iPromocionesDao.findAll();
    }


}
