package com.cristobalbernal.lacasanostraserver.controlers;

import com.cristobalbernal.lacasanostraserver.entidades.VistaReservasFuturas;
import com.cristobalbernal.lacasanostraserver.repo.IVistaReservas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vista")
public class VistaReservas {
    @Autowired
    private IVistaReservas iVistaReservas;

    @GetMapping("/all")
    public List<VistaReservasFuturas> getAll(){
        return iVistaReservas.findAll();
    }

}
