package com.cristobalbernal.lacasanostraserver.controlers;
import com.cristobalbernal.lacasanostraserver.entidades.Tipo;
import com.cristobalbernal.lacasanostraserver.entidades.Usuario;
import com.cristobalbernal.lacasanostraserver.repo.ITipoDao;
import com.cristobalbernal.lacasanostraserver.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/update/{id}")
    public ResponseEntity<Tipo> updateTipo(@PathVariable Long id, @RequestBody Tipo tipo) {
        Optional<Tipo> optionalTipo = iTipoDao.findById(Math.toIntExact(id));
        if (optionalTipo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Tipo existingTipo = optionalTipo.get();
        existingTipo.setNombre(tipo.getNombre());
        existingTipo.setDescripcion(tipo.getDescripcion());
        existingTipo.setImagen(tipo.getImagen());
        // Actualiza los demás campos según sea necesario
        Tipo updatedTipo = iTipoDao.save(existingTipo);
        return ResponseEntity.ok(updatedTipo);
    }
}
