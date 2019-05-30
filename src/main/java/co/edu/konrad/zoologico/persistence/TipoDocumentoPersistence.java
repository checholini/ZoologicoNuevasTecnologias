/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.TipoDocumentoEntity;
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
public class TipoDocumentoPersistence {
    /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un tipo de documento
    * @param a
    * @return 
    */
    
    public TipoDocumentoEntity insert(TipoDocumentoEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los tipos de documento
    */
    
    public List<TipoDocumentoEntity> findAll(){
        Query results = em.createQuery("select a from TipoDocumentoEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public TipoDocumentoEntity find(long id){
        return em.find(TipoDocumentoEntity.class, id);
    }
    
   /*
    * Metodo para borrar un tipo de documento segun id
    * @param id
    */
    public void delete(long id){
        TipoDocumentoEntity entity = em.find(TipoDocumentoEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar un tipo de documento
     * @param z
     * @return 
     */
    public TipoDocumentoEntity update(TipoDocumentoEntity z){
        return em.merge(z);
    }
}
