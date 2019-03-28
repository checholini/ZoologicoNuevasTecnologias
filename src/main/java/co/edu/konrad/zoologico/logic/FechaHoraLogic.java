/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

import co.edu.konrad.zoologico.Entities.FechaHoraEntity;
import co.edu.konrad.zoologico.persistence.FechaHoraPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Sergio S. Salcedo T.
 */
@Stateless
public class FechaHoraLogic {
    @Inject
    private FechaHoraPersistence persistence;
    
    /**
     * Metodo para obtener todas las Fechas y Horas
     * @return 
     */
    public List<FechaHoraEntity> obtenerFechasHoras (){
        List<FechaHoraEntity> FH  = persistence.findAll();
        return FH ;
    }
    /**
     * Metodo para retornar por id
     * @param id
     * @return 
     */
    public FechaHoraEntity obtenerFechasHorasPorId(int id){
        FechaHoraEntity FH =persistence.find(id);
        if(FH  == null){
            throw new IllegalArgumentException("Producto Solicitado no existe");
        }
        return FH ;
    }
    /**
     * metodo para crear una Fecha y Hora
     * @param entity
     * @return 
     */
    public FechaHoraEntity crearFechasHoras(FechaHoraEntity entity){
        persistence.insert(entity);
        return entity;
    }
    /**
     * Actualizar una Fecha y Hora
     * @param entity
     * @param id
     * @return 
     */
    public FechaHoraEntity actualizarFechasHoras(FechaHoraEntity entity, int id){
      FechaHoraEntity FH = persistence.update(entity);
        return FH ;
    }
    /**
     * eliminar una Fechas y Horas
     * @param id 
     */
    public void eliminarFechasHoras (int id){
        persistence.delete(id);
    }
}
