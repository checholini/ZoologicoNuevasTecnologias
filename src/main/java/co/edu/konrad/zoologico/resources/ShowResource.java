/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.ShowDTO;
import co.edu.konrad.zoologico.Entities.ShowEntity;
import co.edu.konrad.zoologico.logic.ShowLogic;
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
@Path("/show")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShowResource {
    @EJB
    private ShowLogic logic;
    /**
     * metodo para obtener todos los show
     * @return 
     */
    @GET
    public List<ShowDTO> obtenerShows(){
       List<ShowEntity> shows = logic.obtenerShows(); 
       return ShowDTO.toShowList(shows);
    }
    /**
     * metodo para obtener los show por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public ShowDTO obtenerShow(@PathParam("id") int Id){
        ShowEntity entity= logic.obtenerShowPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new ShowDTO(entity);
    }
    /**
     * metodo para crear show
     * @param show
     * @return 
     */
    @POST
    public ShowDTO crearShow(ShowDTO show){
        return new ShowDTO(logic.crearShow(show.toEntity()));
    }
    /**
     * actualizar un show
     * @param show
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public ShowDTO actualizarShow(ShowDTO show,@PathParam("id2") int id){
        ShowEntity entity = logic.obtenerShowPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new ShowDTO(logic.actualizarShow(show.toEntity(), id));
    }
    /**
     * eliminar un show
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarShow(@PathParam("id3") int id){
        ShowEntity entity = logic.obtenerShowPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarShow(id);
    }
    
}
