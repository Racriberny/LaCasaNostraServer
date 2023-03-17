package com.cristobalbernal.lacasanostraserver.controlers;

import com.cristobalbernal.lacasanostraserver.entidades.Producto;
import com.cristobalbernal.lacasanostraserver.repo.IProductorDao;
import com.cristobalbernal.lacasanostraserver.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private IProductorDao iProductorDao;

    @GetMapping("/all")
    public List<Producto> getAutores() {
        return iProductorDao.findAll();
    }

    @PostMapping("/add")
    public boolean addProducto(@RequestBody Producto producto) {
        try {
            Log.i("Nuevo Autor: ", producto.toString());
            iProductorDao.save(producto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updateProducto(@RequestBody Producto producto) {
        try {
            Log.i("Update Autor: ", producto.toString());
            iProductorDao.save(producto);
            return true;
        } catch (Exception e){
            Log.e("Update autor", e.getMessage());
            return false;
        }
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteProducto(@PathVariable("id") Integer id) {
        try {
            iProductorDao.deleteById(id);
            System.out.println("Autor eliminado correctamente");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
