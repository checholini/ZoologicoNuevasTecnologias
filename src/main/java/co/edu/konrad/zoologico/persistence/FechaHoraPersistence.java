/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.FechaHoraEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Sergio S. Salcedo T 
 */
@Stateless
public class FechaHoraPersistence {
     /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar una fecha y hora
    * @param a
    * @return 
    */
    
    public FechaHoraEntity insert(FechaHoraEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos las fechas y horas
    */
    
    public List<FechaHoraEntity> findAll(){
        Query results = em.createQuery("select a from FechaHoraEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public FechaHoraEntity find(long id){
        return em.find(FechaHoraEntity.class, id);
    }
    
    /*
    * Metodo para borrar una fecha y hora segun id
    * @param id
    */
    public void delete(long id){
        FechaHoraEntity entity = em.find(FechaHoraEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar una fecha y hora
     * @param z
     * @return 
     */
    public FechaHoraEntity update(FechaHoraEntity z){
        return em.merge(z);
    }
    
   
}
