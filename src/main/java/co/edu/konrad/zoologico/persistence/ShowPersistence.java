/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.ShowEntity;
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
public class ShowPersistence {
     /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un show
    * @param a
    * @return 
    */
    
    public ShowEntity insert(ShowEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los shows
    */
    
    public List<ShowEntity> findAll(){
        Query results = em.createQuery("select a from ShowEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public ShowEntity find(long id){
        return em.find(ShowEntity.class, id);
    }
    
    /*
    * Metodo para borrar un show segun id
    * @param id
    */
    public void delete(long id){
        ShowEntity entity = em.find(ShowEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar un show
     * @param z
     * @return 
     */
    public ShowEntity update(ShowEntity z){
        return em.merge(z);
    }
    
   
}
