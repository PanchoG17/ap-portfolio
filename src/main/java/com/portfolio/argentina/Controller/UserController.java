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
    
    @GetMapping("/saludar_1/{nombre}")
    public String saludar1(@PathVariable String nombre){
        return "Hola " + nombre + " como andas?";
    }
    
    @GetMapping("/saludar_2")
    public String saludar2(@RequestParam String nombre,
                           @RequestParam String apellido,
                           @RequestParam int id ){
        return "ID:"+id+" | Nombre: " + nombre +" "+ apellido;
    }
    
    //////////////////////////////////////////////////////////////
    
    @GetMapping("/usuarios/traer")
    public List<Usuario> getUsuarios(){
        
        return UsuariosService.getUsuarios();
    }
    
    @PostMapping("/usuarios/crear")
    public String createUsuario(@RequestBody Usuario usuario){
        
        UsuariosService.saveUsuario(usuario);
        return "Usuario creado correctamete";
    }
    
    @DeleteMapping("/usuarios/eliminar/{id}")
    public String deleteUsuario(@PathVariable Long id){
        
        ///// VALIDAR SI EXISTE
        
        UsuariosService.deleteUsuario(id);
        return "Usuario eliminado correctamente";
    }
    
    
    ///// CAMBIAR A POSTMAPPING o parametros
    
    @PutMapping("/usuarios/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id,
                               @RequestParam ("nombre") String nuevoNombre,
                               @RequestParam ("apellido") String nuevoApellido,
                               @RequestParam ("edad") int nuevaEdad)
    {
        Usuario usuario = UsuariosService.findUsuario(id);
        
        Usuario newUsuario = UsuariosService.editUsuario(usuario, nuevoNombre, nuevoApellido, nuevaEdad);
        return newUsuario;
    }
}
