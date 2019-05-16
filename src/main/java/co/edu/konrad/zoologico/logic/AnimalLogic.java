/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.AnimalEntity;
import co.edu.konrad.zoologico.persistence.AnimalPersistance;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic Animal
 * @author SergioRodriguez
 */
@Stateless
public class AnimalLogic {
    /**
     * Inyeccion de persistence
     */
    @Inject
    public AnimalPersistance persistence;

    /**
     * Obtiene una lista con todos los animales
     * @return
     */
    public List<AnimalEntity> getAllanimales(){
        List<AnimalEntity> animal = persistence.findAll();
        return animal;
    }

    /**
     * Metodo para traer un AnimalEntity segun id
     * @param id Parametro de busqueda
     * @return Animal encontrado
     */
    public AnimalEntity getanimalById(long id){
        AnimalEntity animal = persistence.find(id);
        if (animal == null) {
            throw new IllegalArgumentException("El animal solicitado no existe");
        }
        return animal;
    }

    /**
     * Metodo para crear un Animal
     * @param entity Objeto a almacenar
     * @return Animal creado
     */
    public AnimalEntity createAnimal(AnimalEntity entity){
        persistence.insert(entity);
        return entity;
    }

    /**
     * Metodo par actualizar la informacion de un Animal
     * @param entity Animal a actualizar
     * @param id Parametro para buscar
     * @return Animal actualizado
     */
    public AnimalEntity updateAnimal(AnimalEntity entity, int id){
        AnimalEntity animal = persistence.update(entity);
        return animal;
    }

    /**
     * Metodo para eliminar un Animal
     * @param id Parametro de busqueda
     */
    public void deleteAnimal(int id){
        persistence.delete(id);
    }

}
