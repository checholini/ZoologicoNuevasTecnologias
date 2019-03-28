/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.ShowEntity;
import co.edu.konrad.zoologico.persistence.ShowPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Sergio S. Salcedo T.
 */
@Stateless
public class ShowLogic {
    
    @Inject
    private ShowPersistence persistence;
     /**
     * Metodo para obtener todas los show
     * @return 
     */
    public List<ShowEntity> obtenerShows (){
        List<ShowEntity> show  = persistence.findAll();
        return show ;
    }
    /**
     * Metodo para retornar por id
     * @param id
     * @return 
     */
    public ShowEntity obtenerShowPorId(int id){
        ShowEntity show =persistence.find(id);
        if(show  == null){
            throw new IllegalArgumentException("Producto Solicitado no existe");
        }
        return show ;
    }
    /**
     * metodo para crear un show
     * @param entity
     * @return 
     */
    public ShowEntity crearShow(ShowEntity entity){
        persistence.insert(entity);
        return entity;
    }
    /**
     * Actualizar un show
     * @param entity
     * @param id
     * @return 
     */
    public ShowEntity actualizarShow(ShowEntity entity, int id){
      ShowEntity show = persistence.update(entity);
        return show ;
    }
    /**
     * eliminar un show
     * @param id 
     */
    public void eliminarShow (int id){
        persistence.delete(id);
    }
}
