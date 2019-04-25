/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.konrad.zoologico.resources;

import co.edu.konrad.zoologico.DTO.AlimentacionDTO;
import co.edu.konrad.zoologico.Entities.AlimentacionEntity;
import co.edu.konrad.zoologico.logic.AlimentacionLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SergioRodriguez
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/alimentacion")
public class AlimentacionResource {
    @EJB
    private AlimentacionLogic alimentacion;
    
    /**
     * Metodo para retornar todos los datos de alimentacion
     * @return List AlimentacionDTO 
     */
    @GET
    public List<AlimentacionDTO> getAlimentancionList(){
        List<AlimentacionEntity> alimentaciones = alimentacion.getAllAlimentos();
        return AlimentacionDTO.toAlimentacionList(alimentaciones);
    }
    
    /**
     * Obtiene una alimentacion segun un id
     * @param id de Busqueda
     * @return Alimentacion Encontrada
     */
    @GET
    @Path("{id: \\d+}")
    public AlimentacionDTO getAlimentacion(@PathParam("id") int id){
        AlimentacionEntity alimentacionE = alimentacion.getalimentacionById(id);
        if(alimentacionE == null){
            throw new RuntimeException("La alimentacion con id "+id+" no existe");
        }
        return new AlimentacionDTO(alimentacion.createAlimento(alimentacionE));
    }
    
    /**
     * Metodo para crear una alimentacion
     * @param alimentacionDTO
     * @return 
     */
    @POST
    public AlimentacionDTO createAlimentacion(AlimentacionDTO alimentacionDTO){
        return new AlimentacionDTO(alimentacion.createAlimento(alimentacionDTO.toEntity()));
    }
    
    /**
     * Actualiza un alimento
     * @param id
     * @return AlimentacionDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public AlimentacionDTO updateAlimentacion(@PathParam("id") int id){
        AlimentacionEntity alimentacionE = alimentacion.getalimentacionById(id);
        if(alimentacionE == null){
            throw new RuntimeException("La alimentacion con id "+id+" no existe");
        }
        return new AlimentacionDTO(alimentacion.updateAlimento(alimentacionE,id));
    }
    
    /**
     * Metodo para eliminar una alimentacion    
     * @param id 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProducto(@PathParam("id") int id){
        AlimentacionEntity alimentacionE = alimentacion.getalimentacionById(id);
        if(alimentacionE == null){
            throw new RuntimeException("La alimentacion con id "+id+" no existe");
        }
        alimentacion.deleteAlimento(id);
    }
}
