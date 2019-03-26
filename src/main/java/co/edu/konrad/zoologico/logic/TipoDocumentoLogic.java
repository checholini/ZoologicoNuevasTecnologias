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
import co.edu.konrad.zoologico.Entities.TipoDocumentoEntity;
import co.edu.konrad.zoologico.persistence.TipoDocumentoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TipoDocumentoLogic {

    @Inject
    private TipoDocumentoPersistence persistence;

    /**
     * Metodo para obtener todos los tipos de documento
     *
     * @return
     */
    public List<TipoDocumentoEntity> obtenerTipoDocumento() {
        List<TipoDocumentoEntity> tipoDocumento = persistence.findAll();
        return tipoDocumento;
    }

    /**
     * Metodo para retornar por id
     *
     * @param id
     * @return
     */
    public TipoDocumentoEntity obtenerTipoDocumentoPorId(int id) {
        TipoDocumentoEntity tipoDocumento = persistence.find(id);
        if (tipoDocumento == null) {
            throw new IllegalArgumentException("Tipo de documento Solicitado no existe");
        }
        return tipoDocumento;
    }

    /**
     * metodo para crear un tipo de documento
     *
     * @param entity
     * @return
     */
    public TipoDocumentoEntity crearTipoDocumento(TipoDocumentoEntity entity) {
        persistence.insert(entity);
        return entity;
    }

    /**
     * Actualizar un tipo de documento
     *
     * @param entity
     * @param id
     * @return
     */
    public TipoDocumentoEntity actualizarTipoDocumento(TipoDocumentoEntity entity, int id) {
        TipoDocumentoEntity tipoDocumento = persistence.update(entity);
        return tipoDocumento;
    }

    /**
     * eliminar un tipo de documento
     *
     * @param id
     */
    public void eliminarTipoDocumento(int id) {
        persistence.delete(id);
    }
}
