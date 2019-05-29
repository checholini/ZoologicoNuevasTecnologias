/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.RatingAnimalEntity;
import co.edu.konrad.zoologico.persistence.RatingAnimalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic para rating de animales
 * @author SergioRodriguez
 */
@Stateless
public class RatingAnimalLogic {
     /**
     * Inyeccion de persistence
     */
    @Inject
    public RatingAnimalPersistence persistence;

    /**
     * Obtiene una lista con todos los Ratinganimales
     * @return
     */
    public List<RatingAnimalEntity> getAllRatinganimales(){
        List<RatingAnimalEntity> Ratinganimal = persistence.findAll();
        return Ratinganimal;
    }

    /**
     * Metodo para traer un RatingAnimalEntity segun id
     * @param id Parametro de busqueda
     * @return RatingAnimal encontrado
     */
    public RatingAnimalEntity getRatinganimalById(long id){
        RatingAnimalEntity Ratinganimal = persistence.find(id);
        if (Ratinganimal == null) {
            throw new IllegalArgumentException("El Ratinganimal solicitado no existe");
        }
        return Ratinganimal;
    }

    /**
     * Metodo para crear un RatingAnimal
     * @param entity Objeto a almacenar
     * @return RatingAnimal creado
     */
    public RatingAnimalEntity createRatingAnimal(RatingAnimalEntity entity){
        persistence.insert(entity);
        return entity;
    }

    /**
     * Metodo par actualizar la informacion de un RatingAnimal
     * @param entity RatingAnimal a actualizar
     * @param id Parametro para buscar
     * @return RatingAnimal actualizado
     */
    public RatingAnimalEntity updateRatingAnimal(RatingAnimalEntity entity, long id){
        RatingAnimalEntity Ratinganimal = persistence.update(entity);
        return Ratinganimal;
    }

    /**
     * Metodo para eliminar un RatingAnimal
     * @param id Parametro de busqueda
     */
    public void deleteRatingAnimal(long id){
        persistence.delete(id);
    }
}
