/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import co.edu.konrad.zoologico.Entities.ParticipantesEntity;
/**
 *
 * @author Oscar Ortiz
 */
@Stateless
public class ParticipantesPersistence {
     /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
 /**
    * Metodo para insertar un participante
    * @param a
    * @return 
    */
    
    public ParticipantesEntity insert(ParticipantesEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los participantes
    */
    
    public List<ParticipantesEntity> findAll(){
        Query results = em.createQuery("select a from ParticipantesEntity a");
        return results.getResultList();
    }
    
    /**
     * Metodo para encontrar por id
     * @param id
     * @return 
     */
    public  ParticipantesEntity find(int id){
        return em.find(ParticipantesEntity.class, id);
    }
    
    /*
    * Metodo para borrar un participante segun id
    * @param id
    */
    public void delete(int id){
         ParticipantesEntity entity = em.find( ParticipantesEntity.class,id);
        em.remove(entity);
    }
    
   /**
     * metodo para actualizar un participante
     * @param z
     * @return 
     */
    public  ParticipantesEntity update( ParticipantesEntity z){
        return em.merge(z);
    }
}
