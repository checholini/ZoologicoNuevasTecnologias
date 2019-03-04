/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.ZooEntity;
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
public class ZooPersistence {
   
     /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un zoologico
    * @param a
    * @return 
    */
    
    public ZooEntity insert(ZooEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los zoologicos
    */
    
    public List<ZooEntity> findAll(){
        Query results = em.createQuery("select a from ZooEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public ZooEntity find(int id){
        return em.find(ZooEntity.class, id);
    }
    
    /*
    * Metodo para borrar un zoologico segun id
    * @param id
    */
    public void delete(int id){
        ZooEntity entity = em.find(ZooEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar un zoologico
     * @param z
     * @return 
     */
    public ZooEntity update(ZooEntity z){
        return em.merge(z);
    }
    
   
}
