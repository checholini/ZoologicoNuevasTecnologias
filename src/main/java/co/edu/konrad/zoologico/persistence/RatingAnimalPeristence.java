/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.RatingAnimalEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Declaracion de entity manager para la tabla rating_animal
 * @author SergioRodriguez
 */
public class RatingAnimalPeristence {
    /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un rating del animal
    * @param ra Objeto de tipo RatingAnimalEntity
    * @return Objeto de tipo RatingAnimalEntity almacenado
    */
    
    public RatingAnimalEntity insert(RatingAnimalEntity ra){
        em.persist(ra);
        return ra;
    }
    
    /**
    * Metodo para listar todos los ratings de los animal
    * @return Lista con todos los Objetos tipo RatingAnimalEntity
    */
    
    public List<RatingAnimalEntity> findAll(){ 
        Query results = em.createQuery("select ra from RatingAnimalEntity ra");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id Indice para buscar
     * @return Retorna un objeto de tipo AnimalEntity
     */
    public RatingAnimalEntity find(int id){
        return em.find(RatingAnimalEntity.class, id);
    }
    
    /**
    * Metodo para borrar un rating del animal segun id
    * @param id Indice para buscar
    */
    public void delete(int id){
        RatingAnimalEntity entity = em.find(RatingAnimalEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar el rating de un animal
     * @param ra Objeto de tipo RatingAnimalEntity
     * @return Objeto de tipo RatingAnimalEntity actualizado
     */
    public RatingAnimalEntity update(RatingAnimalEntity ra){
        return em.merge(ra);
    }
    
}

