/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.TipoDocumentoDTO;
import co.edu.konrad.zoologico.Entities.TipoDocumentoEntity;
import co.edu.konrad.zoologico.logic.TipoDocumentoLogic;
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
@Path("/tipodedocumento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoDeDocumentoResource {
     @EJB
    private TipoDocumentoLogic logic;
    /**
     * metodo para obtener todos los tipos de documentos
     * @return 
     */
    @GET
    public List<TipoDocumentoDTO> obtenerTipoDeDocumento(){
       List<TipoDocumentoEntity> TipoDeDocumento = logic.obtenerTipoDocumento(); 
       return TipoDocumentoDTO.toZooList(TipoDeDocumento);
    }
    /**
     * metodo para obtener TipoDeDocumento por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public TipoDocumentoDTO obtenerTipoDeDocumento(@PathParam("id") int Id){
        TipoDocumentoEntity entity= logic.obtenerTipoDocumentoPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new TipoDocumentoDTO(entity);
    }
    /**
     * metodo para crear TipoDeDocumento
     * @param TipoDeDocumento
     * @return 
     */
    @POST
    public TipoDocumentoDTO crearTipoDeDocumento(TipoDocumentoDTO TipoDeDocumento){
        return new TipoDocumentoDTO(logic.crearTipoDocumento(TipoDeDocumento.toEntity()));
    }
    /**
     * actualizar un TipoDeDocumento
     * @param TipoDeDocumento
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public TipoDocumentoDTO actualizarTipoDeDocumento(TipoDocumentoDTO TipoDeDocumento,@PathParam("id2") int id){
        TipoDocumentoEntity entity = logic.obtenerTipoDocumentoPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new TipoDocumentoDTO(logic.actualizarTipoDocumento(TipoDeDocumento.toEntity(), id));
    }
    /**
     * eliminar un TipoDeDocumento
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarTipoDeDocumento(@PathParam("id3") int id){
        TipoDocumentoEntity entity = logic.obtenerTipoDocumentoPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarTipoDocumento(id);
    }
}
