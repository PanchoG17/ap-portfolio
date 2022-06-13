/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.argentina.Controller;

import com.portfolio.argentina.Model.Usuario;
import com.portfolio.argentina.Service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author usuario
 */
@RestController
public class UserController {
    
    @Autowired
    private IUsuarioService UsuariosService;
       
    // Get Usuarios
    @GetMapping("/usuarios/traer")
    public List<Usuario> getUsuarios(){
        
        return UsuariosService.getUsuarios();
    }
    
    // Crear Usuario
    @PostMapping("/usuarios/crear")
    public String createUsuario(@RequestBody Usuario usuario){
        
        UsuariosService.saveUsuario(usuario);
        return "Usuario creado correctamete";
    }
    
    // Delete Usuario
    @DeleteMapping("/usuarios/eliminar/{id}")
    public String deleteUsuario(@PathVariable Long id){
        
        Usuario usuario = UsuariosService.findUsuario(id);
        
        if(usuario != null){
            UsuariosService.deleteUsuario(id);
            return "Usuario eliminado correctamente";
        }
        else{
            return "El usuario no existe";
        }

    }
    
    // Editar Usuario
    @PutMapping("/usuarios/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id,
                               @RequestParam ("nombre") String nuevoNombre,
                               @RequestParam ("apellido") String nuevoApellido,
                               @RequestParam ("foto") String nuevaFoto,
                               @RequestParam ("titulo") String nuevoTitulo,
                               @RequestParam ("informacion") String nuevaInformacion)
    {
        Usuario usuario = UsuariosService.findUsuario(id);
        
        Usuario newUsuario = UsuariosService.editUsuario(usuario, nuevoNombre, nuevoApellido,nuevaFoto, nuevoTitulo, nuevaInformacion);
        return newUsuario;
    }
}
