/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.EncargadoEntity;
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
public class EncargadoPersistence {
     /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un encargado
    * @param a
    * @return 
    */
    
    public EncargadoEntity insert(EncargadoEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los encargados
    */
    
    public List<EncargadoEntity> findAll(){
        Query results = em.createQuery("select a from EncargadoEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public EncargadoEntity find(int id){
        return em.find(EncargadoEntity.class, id);
    }
    
   /*
    * Metodo para borrar un encargado segun id
    * @param id
    */
    public void delete(int id){
        EncargadoEntity entity = em.find(EncargadoEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar un encargado
     * @param z
     * @return 
     */
    public EncargadoEntity update(EncargadoEntity z){
        return em.merge(z);
    }
}
