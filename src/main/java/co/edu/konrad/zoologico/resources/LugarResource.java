/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.LugarDTO;
import co.edu.konrad.zoologico.Entities.LugarEntity;
import co.edu.konrad.zoologico.logic.LugarLogic;
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
@Path("/lugar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LugarResource {
    @EJB
    private LugarLogic logic;
    /**
     * metodo para obtener todos los lugares
     * @return 
     */
    @GET
    public List<LugarDTO> obtenerLugares(){
       List<LugarEntity> lugares = logic.obtenerLugares(); 
       return LugarDTO.toZooList(lugares);
    }
    /**
     * metodo para obtener lugares por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public LugarDTO obtenerLugar(@PathParam("id") int Id){
        LugarEntity entity= logic.obtenerLugarPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new LugarDTO(entity);
    }
    /**
     * metodo para crear lugares
     * @param lugar
     * @return 
     */
    @POST
    public LugarDTO crearLugar(LugarDTO lugar){
        return new LugarDTO(logic.crearLugar(lugar.toEntity()));
    }
    /**
     * actualizar un Lugar
     * @param lugar
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public LugarDTO actualizarLugar(LugarDTO lugar,@PathParam("id2") int id){
        LugarEntity entity = logic.obtenerLugarPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new LugarDTO(logic.actualizarLugar(lugar.toEntity(), id));
    }
    /**
     * eliminar un Lugar
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarLugar(@PathParam("id3") int id){
        LugarEntity entity = logic.obtenerLugarPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarLugar(id);
    }
    
}
