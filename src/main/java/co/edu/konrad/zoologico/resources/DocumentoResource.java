/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.resources;
import co.edu.konrad.zoologico.DTO.DocumentoDTO;
import co.edu.konrad.zoologico.Entities.DocumentoEntity;
import co.edu.konrad.zoologico.logic.DocumentoLogic;
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
@Path("/documento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentoResource {
    @EJB
    private DocumentoLogic logic;
    /**
     * metodo para obtener todos los documentos
     * @return 
     */
    @GET
    public List<DocumentoDTO> obtenerDocumento(){
       List<DocumentoEntity> documento= logic.obtenerDocumento(); 
       return DocumentoDTO.toZooList(documento);
    }
    /**
     * metodo para obtener documento por id
     * @param Id
     * @return 
     */
    @Path("{id: \\d+}")
    @GET
    public DocumentoDTO obtenerDocumento(@PathParam("id") int Id){
        DocumentoEntity entity= logic.obtenerDocumentoPorId(Id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new DocumentoDTO(entity);
    }
    /**
     * metodo para crear documento
     * @param documento
     * @return 
     */
    @POST
    public DocumentoDTO crearDocumento(DocumentoDTO documento){
        return new DocumentoDTO(logic.crearDocumento(documento.toEntity()));
    }
    /**
     * actualizar un documento
     * @param documento
     * @param id
     * @return 
     */
    @PUT
    @Path("{id2: \\d+}")
    public DocumentoDTO actualizarDocumento(DocumentoDTO documento,@PathParam("id2") int id){
        DocumentoEntity entity = logic.obtenerDocumentoPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        return new DocumentoDTO(logic.actualizarDocumento(documento.toEntity(), id));
    }
    /**
     * eliminar un documento
     * @param id 
     */
    @Path("{id3: \\d+}")
    @DELETE
    public void eliminarDocumento(@PathParam("id3") int id){
        DocumentoEntity entity = logic.obtenerDocumentoPorId(id);
        if(entity == null){
            throw new RuntimeException("El producto solicitado no existe");
        }
        logic.eliminarDocumento(id);
    }
}
