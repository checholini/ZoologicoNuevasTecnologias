/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.RatingShowEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Sergio S. Salcedo T.
 */
@Stateless
public class RatingShowPersistence {
     /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un rating del show
    * @param a
    * @return 
    */
    
    public RatingShowEntity insert(RatingShowEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los ratings de los shows
    */
    
    public List<RatingShowEntity> findAll(){
        Query results = em.createQuery("select a from RatingShowEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public RatingShowEntity find(int id){
        return em.find(RatingShowEntity.class, id);
    }
    
    /*
    * Metodo para borrar un rating de show segun id
    * @param id
    */
    public void delete(int id){
        RatingShowEntity entity = em.find(RatingShowEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar un rating de show
     * @param z
     * @return 
     */
    public RatingShowEntity update(RatingShowEntity z){
        return em.merge(z);
    }
    
   
}
