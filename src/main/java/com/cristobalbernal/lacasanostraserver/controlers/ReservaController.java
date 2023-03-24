package com.cristobalbernal.lacasanostraserver.controlers;

import com.cristobalbernal.lacasanostraserver.entidades.Reserva;
import com.cristobalbernal.lacasanostraserver.repo.IReservaDao;
import com.cristobalbernal.lacasanostraserver.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private IReservaDao iReservaDao;

    @GetMapping("/all")
    public List<Reserva> getAutores() {
        return iReservaDao.findAll();
    }

    @PostMapping("/add")
    public boolean addReserva(@RequestBody Reserva reserva) {
        try {
            Log.i("Nuevo reserva: ", reserva.toString());
            iReservaDao.save(reserva);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @DeleteMapping(value = "/{id}")
    public boolean deleteReserva(@PathVariable("id") Integer id) {
        try {
            iReservaDao.deleteById(id);
            System.out.println("Reserva eliminada correctamente");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
