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
    
   /*
    * Metodo para insertar un rating del animal
    * @param RatingAnimalEntity
    * @return RatingAnimalEntity
    */
    
    public RatingAnimalEntity insert(RatingAnimalEntity ra){
        em.persist(ra);
        return ra;
    }
    
    /*
    * Metodo para listar todos los ratings de los animal
    */
    
    public List<RatingAnimalEntity> findAll(){ 
        Query results = em.createQuery("select ra from RatingAnimalEntity ra");
        return results.getResultList();
    }
    
    /*
     * Metodo para encontrar por id
     * @param RatingAnimalEntity
     * @return 
     */
    public RatingAnimalEntity find(int id){
        return em.find(RatingAnimalEntity.class, id);
    }
    
    /*
    * Metodo para borrar un rating del animal segun id
    * @param RatingAnimalEntity
    */
    public void delete(int id){
        RatingAnimalEntity entity = em.find(RatingAnimalEntity.class,id);
        em.remove(entity);
    }
    
    /*
     * metodo para actualizar el rating de un animal
     * @param RatingAnimalEntity
     * @return 
     */
    public RatingAnimalEntity update(RatingAnimalEntity ra){
        return em.merge(ra);
    }
    
}

