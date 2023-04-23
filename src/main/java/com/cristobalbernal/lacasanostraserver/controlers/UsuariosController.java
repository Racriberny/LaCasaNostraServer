package com.cristobalbernal.lacasanostraserver.controlers;

import com.cristobalbernal.lacasanostraserver.entidades.Usuario;
import com.cristobalbernal.lacasanostraserver.repo.IUsuarioDao;
import com.cristobalbernal.lacasanostraserver.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
            if (user.getCorreoElectronico().equals(usuario.getCorreoElectronico())){
                return false;
            }
        }

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
    public Usuario login(@RequestBody Usuario user) {
        for (Usuario usuario:getUsers()){
            if (usuario.getCorreoElectronico().equals(user.getCorreoElectronico()) && user.getContrasena().equals(usuario.getContrasena())){
                return usuario;
            }
        }
        return null;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario user) {
        Optional<Usuario> optionalUser = iUsuarioDao.findById(Math.toIntExact(id));
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Usuario existingUser = optionalUser.get();
        existingUser.setNombre(user.getNombre());
        existingUser.setApellidos(user.getApellidos());
        existingUser.setCorreoElectronico(user.getCorreoElectronico());
        existingUser.setContrasena(user.getContrasena());
        // Actualiza los demás campos según sea necesario
        Usuario updatedUser = iUsuarioDao.save(existingUser);
        return ResponseEntity.ok(updatedUser);
    }
}
