/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.TipoAnimalEntity;
import co.edu.konrad.zoologico.persistence.TipoAnimalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic TipoAnimal
 * @author SergioRodriguez
 */
@Stateless
public class TipoAnimalLogic {
    /**
     * Inyeccion de persistence
     */
    @Inject
    public TipoAnimalPersistence persistence;
    
    /**
     * Obtiene una lista con todos los Tipos de Animales
     * @return 
     */
    public List<TipoAnimalEntity> getAllTipoAnimales(){
        List<TipoAnimalEntity> tipoAnimal = persistence.findAll();
        return tipoAnimal;
    }
    
    /**
     * Metodo para traer un TipoAnimalEntity segun id
     * @param id Parametro de busqueda
     * @return Tipo de Animal encontrado
     */
    public TipoAnimalEntity getTipoAnimalById(int id){
        TipoAnimalEntity tipoAnimal = persistence.find(id);
        if (tipoAnimal == null) {
            throw new IllegalArgumentException("El tipo de animal solicitado no existe");
        }
        return tipoAnimal;
    }
    
    /**
     * Metodo para crear un TipoAnimal 
     * @param entity Objeto a almacenar
     * @return TipoAnimal creado
     */
    public TipoAnimalEntity createTipoAnimal(TipoAnimalEntity entity){
        persistence.insert(entity);
        return entity;
    }
    
    /**
     * Metodo par actualizar la informacion de un Tipo de Animal
     * @param entity TipoAnimal a actualizar
     * @param id Parametro para buscar
     * @return TipoAnimal actualizado
     */
    public TipoAnimalEntity updateTipoAnimal(TipoAnimalEntity entity, int id){
        TipoAnimalEntity TipoAnimal = persistence.update(entity);
        return TipoAnimal;
    }
    
    /**
     * Metodo para eliminar un TipoAnimal
     * @param id Parametro de busqueda
     */
    public void deleteTipoAnimal(int id){
        persistence.delete(id);
    }
    
}
