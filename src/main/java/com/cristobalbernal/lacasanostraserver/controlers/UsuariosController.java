package com.cristobalbernal.lacasanostraserver.controlers;

import com.cristobalbernal.lacasanostraserver.entidades.Usuario;
import com.cristobalbernal.lacasanostraserver.repo.IUsuarioDao;
import com.cristobalbernal.lacasanostraserver.util.HashGenerator;
import com.cristobalbernal.lacasanostraserver.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {
    @Autowired
    private IUsuarioDao iUsuarioDao;

    @GetMapping("/all")
    public List<Usuario> getUsers() {
        return iUsuarioDao.findAll();
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody Usuario usuario) {
        for (Usuario user: iUsuarioDao.findAll()) {
            if (user.getNombre().equals(usuario.getNombre())){
                return false;
            }
        }

        String contrasena = "";
        try{
            contrasena = HashGenerator.getSHAString(usuario.getContrasena());
        }catch (NoSuchFieldError | NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        usuario.setContrasena(contrasena);
        usuario.setAdmin((byte) 0);
        try {
            Log.i("Nuevo Usuario: ", usuario.toString());
            iUsuarioDao.save(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @DeleteMapping(value = "/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        try {
            iUsuarioDao.deleteById(id);
            System.out.println("Usuario eliminado correctamente");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Usuario user) {

        try {
            for (Usuario usuario: getUsers()) {
                if (usuario.getNombre().equals(user.getNombre()) && (user.getContrasena()).equals(usuario.getContrasena())) {
                    return true;
                }
            }
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
