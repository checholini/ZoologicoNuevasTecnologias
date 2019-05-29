/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.CuidadorDTO;
import co.edu.konrad.zoologico.Entities.CuidadorEntity;
import co.edu.konrad.zoologico.logic.CuidadorLogic;
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
@Path("/cuidador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CuidadorResource {
     @EJB
    private CuidadorLogic logic;
    /**
     * metodo para obtener todos los cuidadores
     * @return 
     */
    @GET
    public List<CuidadorDTO> obtenerCuidador(){
       List<CuidadorEntity> cuidador = logic.obtenerCuidador(); 
       return CuidadorDTO.toZooList(cuidador);
    }
    /**
     * metodo para obtener cuidador por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public CuidadorDTO obtenerCuidador(@PathParam("id") Long Id){
        CuidadorEntity entity= logic.obtenerCuidadorPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new CuidadorDTO(entity);
    }
    /**
     * metodo para crear cuidador
     * @param cuidador
     * @return 
     */
    @POST
    public CuidadorDTO crearCuidador(CuidadorDTO cuidador){
        return new CuidadorDTO(logic.crearCuidador(cuidador.toEntity()));
    }
    /**
     * actualizar un cuidador
     * @param cuidador
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public CuidadorDTO actualizarCuidador(CuidadorDTO cuidador,@PathParam("id2") Long id){
        CuidadorEntity entity = logic.obtenerCuidadorPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new CuidadorDTO(logic.actualizarCuidador(cuidador.toEntity(), id));
    }
    /**
     * eliminar un cuidador
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarCuidador(@PathParam("id3") Long id){
        CuidadorEntity entity = logic.obtenerCuidadorPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarCuidador(id);
    }
}
