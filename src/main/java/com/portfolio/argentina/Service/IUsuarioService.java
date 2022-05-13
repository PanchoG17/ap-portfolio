/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.argentina.Service;

import com.portfolio.argentina.Model.Usuario;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IUsuarioService {
    
    // find usuario
    public Usuario findUsuario(Long id);
    
    // get all usuarios
    public List<Usuario> getUsuarios();
    
    // new usuario
    public void saveUsuario(Usuario usuario);
    
    // edit usuario
    public Usuario editUsuario(Usuario usuario,String nombre, String apellido, String foto, String titulo, String informacion);
    
    // delete usuario
    public void deleteUsuario(Long id);

}
