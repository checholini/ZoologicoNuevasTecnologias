/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.Entities;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Oscar Ortiz
 */
@Entity
@Table(name = "Documento")
public class DocumentoEntity implements Serializable {

    /**
     * Llave primaria de documento
     */
    @Id
    @Column(name = "id_documento")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idDocumento;
    /**
     * Attr: Nombre id tipo de documento
     */
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoEntity idTipoDocumento;
     /**
     * Attr: Nombre de documento
     */
    @Column(name = "nom_documento")
    private String nomDocumento;

    public DocumentoEntity() {
    }

    public long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public TipoDocumentoEntity getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumentoEntity idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNomDocumento() {
        return nomDocumento;
    }

    public void setNomDocumento(String nomDocumento) {
        this.nomDocumento = nomDocumento;
    }



}
