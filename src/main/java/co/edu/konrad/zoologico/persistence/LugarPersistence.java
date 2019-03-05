/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.LugarEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * Sergio S. Salcedo T.
 */
@Stateless
public class LugarPersistence {
    
     /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un Lugar
    * @param a
    * @return 
    */
    
    public LugarEntity insert(LugarEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los lugares
    */
    
    public List<LugarEntity> findAll(){
        Query results = em.createQuery("select a from LugarEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public LugarEntity find(int id){
        return em.find(LugarEntity.class, id);
    }
    
    /*
    * Metodo para borrar un lugar segun id
    * @param id
    */
    public void delete(int id){
        LugarEntity entity = em.find(LugarEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar un lugar
     * @param z
     * @return 
     */
    public LugarEntity update(LugarEntity z){
        return em.merge(z);
    }
    
   
}
