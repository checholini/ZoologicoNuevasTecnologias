/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.RatingShowEntity;
import co.edu.konrad.zoologico.persistence.RatingShowPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Sergio S. Salcedo T.
 */

@Stateless
public class RatingShowLogic {
    
    @Inject
    private RatingShowPersistence persistence;
    
      /**
     * Metodo para obtener todas los Rating shows
     * @return 
     */
    public List<RatingShowEntity> obtenerRatingShows (){
        List<RatingShowEntity> Rshow  = persistence.findAll();
        return Rshow ;
    }
    /**
     * Metodo para retornar por id
     * @param id
     * @return 
     */
    public RatingShowEntity obtenerRatingShowPorId(long id){
        RatingShowEntity Rshow =persistence.find(id);
        if(Rshow  == null){
            throw new IllegalArgumentException("Producto Solicitado no existe");
        }
        return Rshow ;
    }
    /**
     * metodo para crear un Rating show
     * @param entity
     * @return 
     */
    public RatingShowEntity crearRatingShow(RatingShowEntity entity){
        persistence.insert(entity);
        return entity;
    }
    /**
     * Actualizar un Rating show
     * @param entity
     * @param id
     * @return 
     */
    public RatingShowEntity actualizarRatingShow(RatingShowEntity entity, long id){
      RatingShowEntity Rshow = persistence.update(entity);
        return Rshow ;
    }
    /**
     * eliminar un Rating show
     * @param id 
     */
    public void eliminarRatingShow (long id){
        persistence.delete(id);
    }
}
