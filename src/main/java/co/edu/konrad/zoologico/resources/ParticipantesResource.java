/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.ParticipanteDTO;
import co.edu.konrad.zoologico.Entities.ParticipantesEntity;
import co.edu.konrad.zoologico.logic.ParticipantesLogic;
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
@Path("/participantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParticipantesResource {
    @EJB
    private ParticipantesLogic logic;
    /**
     * metodo para obtener todos los participantes
     * @return 
     */
    @GET
    public List<ParticipanteDTO> obtenerParticipantes(){
       List<ParticipantesEntity> participante = logic.obtenerParticipantes(); 
       return ParticipanteDTO.toZooList(participante);
    }
    /**
     * metodo para obtener participante por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public ParticipanteDTO obtenerParticipantes(@PathParam("id") int Id){
        ParticipantesEntity entity= logic.obtenerParticipantePorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new ParticipanteDTO(entity);
    }
    /**
     * metodo para crear participante
     * @param participante
     * @return 
     */
    @POST
    public ParticipanteDTO crearParticipantes(ParticipanteDTO participante){
        return new ParticipanteDTO(logic.crearParticipante(participante.toEntity()));
    }
    /**
     * actualizar un participante
     * @param participante
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public ParticipanteDTO actualizarParticipantes(ParticipanteDTO participante,@PathParam("id2") int id){
        ParticipantesEntity entity = logic.obtenerParticipantePorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new ParticipanteDTO(logic.actualizarParticipante(participante.toEntity(), id));
    }
    /**
     * eliminar un participante
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarParticipantes(@PathParam("id3") int id){
        ParticipantesEntity entity = logic.obtenerParticipantePorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarParticipante(id);
    }
}
