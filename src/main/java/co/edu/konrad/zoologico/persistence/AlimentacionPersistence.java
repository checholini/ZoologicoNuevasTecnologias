/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.AlimentacionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Creacion de manejador para Alimentacion
 * @author SergioRodriguez
 */

@Stateless
public class AlimentacionPersistence {
    /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para agregar un alimento
    * @param a Objeto de tipo AlimentacionEntity
    * @return Objeto almacenado de tipo AlimentacionEntity
    */
    
    public AlimentacionEntity insert(AlimentacionEntity a){
        em.persist(a);
        return a;
    }
    
    /**
    * Metodo para listar todos los alimentos
    * @return Retorna una lista con los Objetos almacenados.
    */
    
    public List<AlimentacionEntity> findAll(){
        Query results = em.createQuery("select a from AlimentacionEntity a");
        return results.getResultList();
    }
    
    /**
    * Metodo para encontrar por id
    * @param id Indice para buscar
    * @return Retorna un objeto de tipo AlimentacionEntity
    */
    public AlimentacionEntity find(int id){
        return em.find(AlimentacionEntity.class, id);
    }
    
    /**
    * Metodo para borrar un alimento segun id
    * @param id Indice para buscar
    */
    public void delete(int id){
        AlimentacionEntity entity = find(id);
        em.remove(entity);
    }
    
    /**
    * Metodo para modificar alimentos
    * @param a Objeto de tipo AlimentacionEntity
    * @return Retorna el objeto AlimentacionEntity actualizado
    */
    public AlimentacionEntity update(AlimentacionEntity a){
        return em.merge(a);
    }
    
    
}