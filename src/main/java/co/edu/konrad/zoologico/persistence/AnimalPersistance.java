/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.persistence;

import co.edu.konrad.zoologico.Entities.AnimalEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Manejador para la tabla Animal
 * @author SergioRodriguez
 */

@Stateless
public class AnimalPersistance {
    /*
    * Declaracion manejador
    */
    @PersistenceContext(unitName = "zoologicoPU")
    protected EntityManager em;
    
    /*
    * Metodo para insertar a los animales
    * @param AnimalEntity
    * @return AnimalEntity
    */
    public AnimalEntity insert(AnimalEntity a){
        em.persist(a);
        return a;
    }
    
    /*
    * Metodo para listar todos los animales
    */
    public List<AnimalEntity> findAll(){
        Query q = em.createQuery("select ta from AnimalEntity ta");
        return q.getResultList();
    }
    
    /*
    * Metodo para encontrar segun id
    * @param id
    * @return AnimalEntity
    */
    public AnimalEntity find(int id){
        return em.find(AnimalEntity.class, id);
    }
    
    /*
    * Metodo para actualizar los datos de un animal
    * @param AnimalEntity
    * @return AnimalEntity
    */
    public AnimalEntity update(AnimalEntity ta){
        return em.merge(ta);
    }
    
    /*
    * Metodo para eliminar un animal
    * @param id
    */    
    public void delete(int id){
        AnimalEntity entity = find(id);
        em.remove(entity);
    }
}
