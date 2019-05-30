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
import javax.persistence.Table;

/**
 *
 * @author Oscar Ortiz
 */
@Entity
@Table(name = "TipoDocumento")
public class TipoDocumentoEntity implements Serializable {

    /**
     * Llave primaria del tipo de documento
     */
    @Id
    @Column(name = "id_tipo_documento")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idTipoDocumento;
    /**
     * Attr: Nombre tipo de documento
     */
    @Column(name = "nombre_tipo_documento")
    private String nom_tipo_documento;

    public TipoDocumentoEntity() {
    }

    public long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNom_tipo_documento() {
        return nom_tipo_documento;
    }

    public void setNom_tipo_documento(String nom_tipo_documento) {
        this.nom_tipo_documento = nom_tipo_documento;
    }
}
