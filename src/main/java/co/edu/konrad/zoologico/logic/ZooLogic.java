/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.ZooEntity;
import co.edu.konrad.zoologico.persistence.ZooPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Sergio S. Salcedo T.
 */

@Stateless
public class ZooLogic {
    @Inject
    private ZooPersistence persistence;
    
    /**
     * Metodo para obtener todos los zoologicos
     * @return 
     */
    public List<ZooEntity> obtenerZoos(){
        List<ZooEntity> zoo = persistence.findAll();
        return zoo;
    }
    /**
     * Metodo para retornar por id
     * @param id
     * @return 
     */
    public ZooEntity obtenerZooPorId(long id){
        ZooEntity zoo=persistence.find(id);
        if(zoo == null){
            throw new IllegalArgumentException("Producto Solicitado no existe");
        }
        return zoo;
    }
    /**
     * metodo para crear un zoo
     * @param entity
     * @return 
     */
    public ZooEntity crearZoo(ZooEntity entity){
        persistence.insert(entity);
        return entity;
    }
    /**
     * Actualizar un zoo
     * @param entity
     * @param id
     * @return 
     */
    public ZooEntity actualizarZoo(ZooEntity entity, long id){
      ZooEntity zoo = persistence.update(entity);
        return zoo;
    }
    /**
     * eliminar un zoo
     * @param id 
     */
    public void eliminarZoo (long id){
        persistence.delete(id);
    }
}
