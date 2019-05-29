/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.konrad.zoologico.resources;

import co.edu.konrad.zoologico.DTO.TipoAnimalDTO;
import co.edu.konrad.zoologico.Entities.TipoAnimalEntity;
import co.edu.konrad.zoologico.logic.TipoAnimalLogic;
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
 * @author $SergioRodriguez
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tipoanimal")
public class TipoAnimalResource {
    @EJB
    private TipoAnimalLogic tipoAnimal;
    
    /**
     * Metodo para retornar todos los datos de un tipo de animal
     * @return List TipoanimalDTO 
     */
    @GET
    public List<TipoAnimalDTO> getAlimentancionList(){
        List<TipoAnimalEntity> animales = tipoAnimal.getAllTipoAnimales();
        return TipoAnimalDTO.toTipoAnimalList(animales);
    }
    
    /**
     * Obtiene un tipo de animal segun un id
     * @param id de Busqueda
     * @return tipo de animal Encontrado
     */
    @GET
    @Path("{id: \\d+}")
    public TipoAnimalDTO getanimal(@PathParam("id") int id){
        TipoAnimalEntity animalE = tipoAnimal.getTipoAnimalById(id);
        if(animalE == null){
            throw new RuntimeException("El animal con id "+id+" no existe");
        }
        return new TipoAnimalDTO(animalE);
    }
    
    /**
     * Metodo para crear un tipo de animal
     * @param TipoanimalDTO
     * @return 
     */
    @POST
    public TipoAnimalDTO createanimal(TipoAnimalDTO TipoanimalDTO){
        return new TipoAnimalDTO(tipoAnimal.createTipoAnimal(TipoanimalDTO.toEntity()));
    }
    
    /**
     * Actualiza un tipo de animal
     * @param id
     * @return TipoanimalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public TipoAnimalDTO updateanimal(@PathParam("id") int id, TipoAnimalDTO animalDTO){
        TipoAnimalEntity animalE = tipoAnimal.getTipoAnimalById(id);
        if(animalE == null){
            throw new RuntimeException("El animal con id "+id+" no existe");
        }
        return new TipoAnimalDTO(tipoAnimal.updateTipoAnimal(animalDTO.toEntity(),id));
    }
    
    /**
     * Metodo para eliminar un tipo de animal    
     * @param id 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProducto(@PathParam("id") int id){
        TipoAnimalEntity animalE = tipoAnimal.getTipoAnimalById(id);
        if(animalE == null){
            throw new RuntimeException("El animal con id "+id+" no existe");
        }
        tipoAnimal.deleteTipoAnimal(id);
    }
}
