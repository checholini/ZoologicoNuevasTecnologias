/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.CuidadorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Oscar Ortiz
 */
@Stateless
public class CuidadorPersistence {
    /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un ciudador
    * @param a
    * @return 
    */
    
    public CuidadorEntity insert(CuidadorEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los cuidador
    */
    
    public List<CuidadorEntity> findAll(){
        Query results = em.createQuery("select a from CuidadorEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public CuidadorEntity find(Long id){
        return em.find(CuidadorEntity.class, id);
    }
    
   /*
    * Metodo para borrar un ciudador segun id
    * @param id
    */
    public void delete(Long id){
        CuidadorEntity entity = em.find(CuidadorEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar un cuidador
     * @param z
     * @return 
     */
    public CuidadorEntity update(CuidadorEntity z){
        return em.merge(z);
    }
}
