/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.konrad.zoologico.resources;

import co.edu.konrad.zoologico.DTO.RatingAnimalDTO;
import co.edu.konrad.zoologico.Entities.RatingAnimalEntity;
import co.edu.konrad.zoologico.logic.RatingAnimalLogic;
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
@Path("/ratinganimal")
public class RatingAnimalResource {
    @EJB
    private RatingAnimalLogic Ratinganimal;

    /**
     * Metodo para retornar todos los datos de Ratinganimal
     * @return List RatinganimalDTO
     */
    @GET
    public List<RatingAnimalDTO> getAlimentancionList(){
        List<RatingAnimalEntity> Ratinganimales = Ratinganimal.getAllRatinganimales();
        return RatingAnimalDTO.toRatingAnimalList(Ratinganimales);
    }

    /**
     * Obtiene un Ratinganimal segun un id
     * @param id de Busqueda
     * @return Ratinganimal Encontrado
     */
    @GET
    @Path("{id: \\d+}")
    public RatingAnimalDTO getRatinganimal(@PathParam("id") long id){
        RatingAnimalEntity RatinganimalE = Ratinganimal.getRatinganimalById(id);
        if(RatinganimalE == null){
            throw new RuntimeException("El Ratinganimal con id "+id+" no existe");
        }
        return new RatingAnimalDTO(RatinganimalE);
    }

    /**
     * Metodo para crear una Ratinganimal
     * @param RatinganimalDTO
     * @return
     */
    @POST
    public RatingAnimalDTO createRatinganimal(RatingAnimalDTO RatinganimalDTO){
        return new RatingAnimalDTO(Ratinganimal.createRatingAnimal(RatinganimalDTO.toEntity()));
    }

    /**
     * Actualiza un alimento
     * @param id
     * @param ratingAnimalDTO
     * @return RatinganimalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public RatingAnimalDTO updateRatinganimal(@PathParam("id") long id, RatingAnimalDTO ratingAnimalDTO){
        RatingAnimalEntity RatinganimalE = Ratinganimal.getRatinganimalById(id);
        if(RatinganimalE == null){
            throw new RuntimeException("El Ratinganimal con id "+id+" no existe");
        }
        System.out.println(ratingAnimalDTO.getIdRatingAnimal());
        return new RatingAnimalDTO(Ratinganimal.updateRatingAnimal(ratingAnimalDTO.toEntity(),id));
    }

    /**
     * Metodo para eliminar una Ratinganimal
     * @param id
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProducto(@PathParam("id") long id){
        RatingAnimalEntity RatinganimalE = Ratinganimal.getRatinganimalById(id);
        if(RatinganimalE == null){
            throw new RuntimeException("El Ratinganimal con id "+id+" no existe");
        }
        Ratinganimal.deleteRatingAnimal(id);
    }
}
