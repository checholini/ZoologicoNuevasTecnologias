/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

/**
 *
 * @author Oscar Ortiz.
 */
import co.edu.konrad.zoologico.Entities.DocumentoEntity;
import co.edu.konrad.zoologico.persistence.DocumentoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DocumentoLogic {

    @Inject
    private DocumentoPersistence persistence;

    /**
     * Metodo para obtener todos los documentos
     *
     * @return
     */
    public List<DocumentoEntity> obtenerDocumento() {
        List<DocumentoEntity> documento = persistence.findAll();
        return documento;
    }

    /**
     * Metodo para retornar por id
     *
     * @param id
     * @return
     */
    public DocumentoEntity obtenerDocumentoPorId(int id) {
        DocumentoEntity documento = persistence.find(id);
        if (documento == null) {
            throw new IllegalArgumentException("Documento Solicitado no existe");
        }
        return documento;
    }

    /**
     * metodo para crear un documento
     *
     * @param entity
     * @return
     */
    public DocumentoEntity crearDocumento(DocumentoEntity entity) {
        persistence.insert(entity);
        return entity;
    }

    /**
     * Actualizar un documento
     *
     * @param entity
     * @param id
     * @return
     */
    public DocumentoEntity actualizarDocumento(DocumentoEntity entity, int id) {
        DocumentoEntity documento = persistence.update(entity);
        return documento;
    }

    /**
     * eliminar un documento
     *
     * @param id
     */
    public void eliminarDocumento(int id) {
        persistence.delete(id);
    }
}
