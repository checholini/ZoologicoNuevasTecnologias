/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.FechaHoraDTO;
import co.edu.konrad.zoologico.Entities.FechaHoraEntity;
import co.edu.konrad.zoologico.logic.FechaHoraLogic;
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
@Path("/fechayhora")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FechaHoraResource {
    @EJB
    private FechaHoraLogic logic;
    /**
     * metodo para obtener todos las Fechas y Horas
     * @return 
     */
    @GET
    public List<FechaHoraDTO> obtenerFechasHoras(){
       List<FechaHoraEntity> FH = logic.obtenerFechasHoras(); 
       return FechaHoraDTO.toFHList(FH);
    }
    /**
     * metodo para obtener Fechas y Horas por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public FechaHoraDTO obtenerFechaHora(@PathParam("id") long Id){
        FechaHoraEntity entity= logic.obtenerFechasHorasPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new FechaHoraDTO(entity);
    }
    /**
     * metodo para crear Fecha y Hora
     * @param FH
     * @return 
     */
    @POST
    public FechaHoraDTO crearFechaHora(FechaHoraDTO FH){
        return new FechaHoraDTO(logic.crearFechasHoras(FH.toEntity()));
    }
    /**
     * actualizar una Fecha y Hora
     * @param FH
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public FechaHoraDTO actualizarFechaHora(FechaHoraDTO FH,@PathParam("id2") long id){
        FechaHoraEntity entity = logic.obtenerFechasHorasPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new FechaHoraDTO(logic.actualizarFechasHoras(FH.toEntity(), id));
    }
    /**
     * eliminar un Fecha y Hora
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarFechaHora(@PathParam("id3") long id){
        FechaHoraEntity entity = logic.obtenerFechasHorasPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarFechasHoras(id);
    }
    
}
