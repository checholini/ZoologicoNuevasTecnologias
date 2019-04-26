/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.RatingShowDTO;
import co.edu.konrad.zoologico.Entities.RatingShowEntity;
import co.edu.konrad.zoologico.logic.RatingShowLogic;
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
 * @author Sergio S. Salcedo T.
 */
@Path("/ratingshow")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RatingShowResource {
    @EJB
    private RatingShowLogic logic;
    /**
     * metodo para obtener todos los Rating show
     * @return 
     */
    @GET
    public List<RatingShowDTO> obtenerRatingShows(){
       List<RatingShowEntity> shows = logic.obtenerRatingShows(); 
       return RatingShowDTO.toShowList(shows);
    }
    /**
     * metodo para obtener los Rating show por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public RatingShowDTO obtenerRatingShow(@PathParam("id") int Id){
        RatingShowEntity entity= logic.obtenerRatingShowPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new RatingShowDTO(entity);
    }
    /**
     * metodo para crear Rating show
     * @param show
     * @return 
     */
    @POST
    public RatingShowDTO crearRatingShow(RatingShowDTO show){
        return new RatingShowDTO(logic.crearRatingShow(show.toEntity()));
    }
    /**
     * actualizar un Rating show
     * @param show
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public RatingShowDTO actualizarRatingShow(RatingShowDTO show,@PathParam("id2") int id){
        RatingShowEntity entity = logic.obtenerRatingShowPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new RatingShowDTO(logic.actualizarRatingShow(show.toEntity(), id));
    }
    /**
     * eliminar un Rating show
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarRatingShow(@PathParam("id3") int id){
        RatingShowEntity entity = logic.obtenerRatingShowPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarRatingShow(id);
    }
     
}
