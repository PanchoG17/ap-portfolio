/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.argentina.Service;

import com.portfolio.argentina.Model.Usuario;
import com.portfolio.argentina.Repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public List<Usuario> getUsuarios() {
        List <Usuario> usuariosList = usuarioRepository.findAll();
        return usuariosList;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);        
    }

    @Override
    public Usuario editUsuario(Usuario usuario,String nombre, String apellido, String foto, String titulo, String informacion) {
        
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setFoto(foto);
        usuario.setTitulo(titulo);        
        usuario.setInformacion(informacion);
                
        this.saveUsuario(usuario);
        return usuario;
    }
}
