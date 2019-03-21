/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.AlimentacionEntity;
import co.edu.konrad.zoologico.persistence.AlimentacionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Logic de alimentacion
 * @author SergioRodriguez
 */
@Stateless
public class AlimentacionLogic {
    /**
     * Inyeccion de persistence
     */
    @Inject
    public AlimentacionPersistence persistence;
    
    /**
     * Obtiene una lista con todos los alimentos
     * @return 
     */
    public List<AlimentacionEntity> getAllAlimentos(){
        List<AlimentacionEntity> alimentos = persistence.findAll();
        return alimentos;
    }
    
    /**
     * Metodo para traer un AlimentacionEntity segun id
     * @param id Parametro de busqueda
     * @return Alimento encontrado
     */
    public AlimentacionEntity getalimentacionById(int id){
        AlimentacionEntity alimento = persistence.find(id);
        if (alimento == null) {
            throw new IllegalArgumentException("El alimento solicitado no existe");
        }
        return alimento;
    }
    
    /**
     * Metodo para crear un alimento 
     * @param entity Objeto a almacenar
     * @return Alimento creado
     */
    public AlimentacionEntity createAlimento(AlimentacionEntity entity){
        persistence.insert(entity);
        return entity;
    }
    
    /**
     * Metodo par actualizar la informacion de un alimento
     * @param entity alimento a actualizar
     * @param id Parametro para buscar
     * @return Alimento actualizado
     */
    public AlimentacionEntity updateAlimento(AlimentacionEntity entity, int id){
        AlimentacionEntity alimentacion = persistence.update(entity);
        return alimentacion;
    }
    
    /**
     * Metodo para eliminar un alimento
     * @param id Parametro de busqueda
     */
    public void deleteAlimento(int id){
        persistence.delete(id);
    }
}
