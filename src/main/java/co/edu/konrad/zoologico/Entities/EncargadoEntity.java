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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Oscar Ortiz
 */
@Entity
@Table(name = "Encargado")
public class EncargadoEntity implements Serializable {

    /**
     * Llave primaria del encargado
     */
    @Id
    @Column(name = "id_encargado")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEncargado;
    /**
     * Attr: telefono del encargado
     */
    @Column(name = "telefono_encargado")
    private String telefonoEncargado;
    /**
     * Attr: id tipo de documento
     */
    @OneToOne
    @JoinColumn(name = "id_documento")
    private DocumentoEntity idDocumento;
    
    @Column(name = "nombre_encargado")
    private String nomEncargado;

    public String getNomEncargado() {
        return nomEncargado;
    }

    public void setNomEncargado(String nomEncargado) {
        this.nomEncargado = nomEncargado;
    }
    
    public EncargadoEntity() {
    }

    public long getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(long idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getTelefonoEncargado() {
        return telefonoEncargado;
    }

    public void setTelefonoEncargado(String telefonoEncargado) {
        this.telefonoEncargado = telefonoEncargado;
    }

    public DocumentoEntity getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(DocumentoEntity idDocumento) {
        this.idDocumento = idDocumento;
    }

}
