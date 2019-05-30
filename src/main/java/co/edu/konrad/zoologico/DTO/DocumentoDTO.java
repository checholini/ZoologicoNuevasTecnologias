/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.DocumentoEntity;
import co.edu.konrad.zoologico.Entities.TipoDocumentoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Ortiz.
 */
public class DocumentoDTO {
    
    private long idDocumento;
    private String nomDocumento;
    private TipoDocumentoEntity idTipoDocumento;
    
    public DocumentoDTO() {
    }

    /**
     * De Entity a DTO
     *
     * @param Documento
     */
    public DocumentoDTO(DocumentoEntity documento) {
        this.idDocumento = documento.getIdDocumento();
        this.nomDocumento = documento.getNomDocumento();
        this.idTipoDocumento = documento.getIdTipoDocumento();
    }

    /**
     * Devuelve la lista de documento
     *
     * @param Documento
     * @return
     */
    public static List<DocumentoDTO> toZooList(List<DocumentoEntity> documento) {
        List<DocumentoDTO> listaDocumentos = new ArrayList();
        for (int i = 0; i < documento.size(); i++) {
            listaDocumentos.add(new DocumentoDTO(documento.get(i)));
        }
        return listaDocumentos;
    }

    /**
     * de DTO a Entity
     *
     * @return
     */
    public DocumentoEntity toEntity() {
        DocumentoEntity documentoEntity = new DocumentoEntity();
        documentoEntity.setIdDocumento(this.idDocumento);
        documentoEntity.setNomDocumento(this.nomDocumento);
        documentoEntity.setIdTipoDocumento(this.idTipoDocumento);
        return documentoEntity;
    }

    public long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNomDocumento() {
        return nomDocumento;
    }

    public void setNomDocumento(String nomDocumento) {
        this.nomDocumento = nomDocumento;
    }

    public TipoDocumentoEntity getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumentoEntity idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    

    
}
