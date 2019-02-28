/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.TipoAnimalEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implementacion de manejador para la tabla Tipo Animal
 * @author SergioRodriguez
 */

@Stateless
public class TipoAnimalPersistence {
    /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
    /*
    * Metodo para insertar tipos de animales
    * @param TipoAnimalEntity
    * @return TipoAnimalEntity
    */
    public TipoAnimalEntity insert(TipoAnimalEntity ta){
        em.persist(ta);
        return ta;
    }
    
    /*
    * Metodo para listar los tipos de animales
    */
    public List<TipoAnimalEntity> findAll(){
        Query q = em.createQuery("select ta from TipoAnimalEntity ta");
        return q.getResultList();
    }
    
    /*
    * Metodo para encontrar segun id
    * @param id
    * @return TipoAnimalEntity
    */
    public TipoAnimalEntity find(int id){
        return em.find(TipoAnimalEntity.class, id);
    }
    
    /*
    * Metodo para actualizar un registro de tipo de animal
    * @param TipoAnimalEntity
    * @return TipoAnimalEntity
    */
    public TipoAnimalEntity update(TipoAnimalEntity ta){
        return em.merge(ta);
    }
    
    /*
    * Metodo para eliminar un registro de tipo animal
    * @param id
    */    
    public void delete(int id){
        TipoAnimalEntity entity = find(id);
        em.remove(entity);
    }
}
