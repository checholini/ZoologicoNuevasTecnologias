/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.DocumentoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Ingenieria
 */
@Stateless
public class DocumentoPersistence {
    /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
   /**
    * Metodo para insertar un documento
    * @param a
    * @return 
    */
    
    public DocumentoEntity insert(DocumentoEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los  documentos
    */
    
    public List<DocumentoEntity> findAll(){
        Query results = em.createQuery("select a from DocumentoEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public DocumentoEntity find(Long id){
        return em.find(DocumentoEntity.class, id);
    }
    
   /*
    * Metodo para borrar un documento segun id
    * @param id
    */
    public void delete(Long id){
       DocumentoEntity entity = em.find(DocumentoEntity.class,id);
        em.remove(entity);
    }
    
    /**
     * metodo para actualizar un documento
     * @param z
     * @return 
     */
    public DocumentoEntity update(DocumentoEntity z){
        return em.merge(z);
    }
}
