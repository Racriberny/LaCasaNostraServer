package com.cristobalbernal.lacasanostraserver.controlers;
import com.cristobalbernal.lacasanostraserver.entidades.Tipo;
import com.cristobalbernal.lacasanostraserver.repo.ITipoDao;
import com.cristobalbernal.lacasanostraserver.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo")
public class TipoController {
    @Autowired
    private ITipoDao iTipoDao;

    @GetMapping("/all")
    public List<Tipo> getTipo() {
        return iTipoDao.findAll();
    }

    @PostMapping("/add")
    public boolean addTipo(@RequestBody Tipo tipo) {
        try {
            Log.i("Nuevo tipo: ", tipo.toString());
            iTipoDao.save(tipo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updateTipo(@RequestBody Tipo tipo) {
        try {
            Log.i("Update tipo: ", tipo.toString());
            iTipoDao.save(tipo);
            return true;
        } catch (Exception e){
            Log.e("Update tipo", e.getMessage());
            return false;
        }
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteTipo(@PathVariable("id") Integer id) {
        try {
            iTipoDao.deleteById(id);
            System.out.println("Tipo eliminado correctamente");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
