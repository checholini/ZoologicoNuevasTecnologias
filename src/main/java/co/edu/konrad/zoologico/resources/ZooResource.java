/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.ZooDTO;
import co.edu.konrad.zoologico.Entities.ZooEntity;
import co.edu.konrad.zoologico.logic.ZooLogic;
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
@Path("/zoologico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZooResource {
     @EJB
    private ZooLogic logic;
    /**
     * metodo para obtener todos los zoologicos
     * @return 
     */
    @GET
    public List<ZooDTO> obtenerZoos(){
       List<ZooEntity> zoos = logic.obtenerZoos(); 
       return ZooDTO.toZooList(zoos);
    }
    /**
     * metodo para obtener zoologicos por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public ZooDTO obtenerZoo(@PathParam("id") long Id){
        ZooEntity entity= logic.obtenerZooPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new ZooDTO(entity);
    }
    /**
     * metodo para crear zoologicos
     * @param zoo
     * @return 
     */
    @POST
    public ZooDTO crearZoo(ZooDTO zoo){
        return new ZooDTO(logic.crearZoo(zoo.toEntity()));
    }
    /**
     * actualizar un zoologico
     * @param zoo
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public ZooDTO actualizarZoo(ZooDTO zoo,@PathParam("id2") long id){
        ZooEntity entity = logic.obtenerZooPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new ZooDTO(logic.actualizarZoo(zoo.toEntity(), id));
    }
    /**
     * eliminar un zoologico
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarZoo(@PathParam("id3") long id){
        ZooEntity entity = logic.obtenerZooPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarZoo(id);
    }
    
}
