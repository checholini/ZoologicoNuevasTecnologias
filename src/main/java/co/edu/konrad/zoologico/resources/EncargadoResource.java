/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.EncargadoDTO;
import co.edu.konrad.zoologico.Entities.EncargadoEntity;
import co.edu.konrad.zoologico.logic.EncargadoLogic;
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
 * @author Oscar Ortiz
 */
@Path("/encargado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EncargadoResource {
     @EJB
    private EncargadoLogic logic;
    /**
     * metodo para obtener todos los Encargado
     * @return 
     */
    @GET
    public List<EncargadoDTO> obtenerEncargado(){
       List<EncargadoEntity> encargado = logic.obtenerEncargado(); 
       return EncargadoDTO.toZooList(encargado);
    }
    /**
     * metodo para obtener encargado por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public EncargadoDTO obtenerEncargado(@PathParam("id") int Id){
        EncargadoEntity entity= logic.obtenerEncargadoPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new EncargadoDTO(entity);
    }
    /**
     * metodo para crear encargado
     * @param encargado
     * @return 
     */
    @POST
    public EncargadoDTO crearEncargado(EncargadoDTO encargado){
        return new EncargadoDTO(logic.crearEncargado(encargado.toEntity()));
    }
    /**
     * actualizar un encargado
     * @param encargado
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public EncargadoDTO actualizarEncargado(EncargadoDTO encargado,@PathParam("id2") int id){
        EncargadoEntity entity = logic.obtenerEncargadoPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new EncargadoDTO(logic.actualizarEncargado(encargado.toEntity(), id));
    }
    /**
     * eliminar un encargado
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarEncargado(@PathParam("id3") int id){
        EncargadoEntity entity = logic.obtenerEncargadoPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarEncargado(id);
    }
}
