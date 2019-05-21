/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.LugarEntity;
import co.edu.konrad.zoologico.persistence.LugarPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Sergio S. Salcedo T.
 */

@Stateless
public class LugarLogic {
    @Inject
    private LugarPersistence persistence;
    
    /**
     * Metodo para obtener todos los lugares
     * @return 
     */
    public List<LugarEntity> obtenerLugares(){
        List<LugarEntity> lugar = persistence.findAll();
        return lugar;
    }
    /**
     * Metodo para retornar por id
     * @param id
     * @return 
     */
    public LugarEntity obtenerLugarPorId(long id){
        LugarEntity lugar=persistence.find(id);
        if(lugar == null){
            throw new IllegalArgumentException("Producto Solicitado no existe");
        }
        return lugar;
    }
    /**
     * metodo para crear un lugar
     * @param entity
     * @return 
     */
    public LugarEntity crearLugar(LugarEntity entity){
        persistence.insert(entity);
        return entity;
    }
    /**
     * Actualizar un lugar
     * @param entity
     * @param id
     * @return 
     */
    public LugarEntity actualizarLugar(LugarEntity entity, long id){
      LugarEntity lugar = persistence.update(entity);
        return lugar;
    }
    /**
     * eliminar un lugar
     * @param id 
     */
    public void eliminarLugar (long id){
        persistence.delete(id);
    }
}
