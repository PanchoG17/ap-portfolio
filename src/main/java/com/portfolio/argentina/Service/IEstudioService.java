/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.argentina.Service;

import com.portfolio.argentina.Model.Estudio;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IEstudioService {
    
    // find usuario
    public Estudio findEstudio(Long id);
    
    // get all usuarios
    public List<Estudio> getEstudios();
    
    // new usuario
    public void saveEstudios(Estudio estudio);
    
    // edit usuario
    public Estudio editEstudio(Estudio usuario,String nuevoNombre, String nuevoApellido, int nuevaEdad);
    
    // delete usuario
    public void deleteEstudio(Long id);
}
