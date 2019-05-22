/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Sergio S. Salcedo T.
 */
@Entity
@Table(name="Show")
public class ShowEntity implements Serializable {
    /**
     * Attr: Id del show
     */
    @Id
    @Column(name = "id_show")
   @GeneratedValue(strategy= GenerationType.AUTO)
    private long idShow;
    /**
     * Attr: Id de encargado
     */
    @ManyToOne
     @JoinColumn(name = "id_encargado")
     private EncargadoEntity idEncargado;
    /**
     * Attr: Id del zoologico
     */
    @ManyToOne
     @JoinColumn(name = "id_zoo")
     private ZooEntity idZoo;
    /**
     * Attr:nombre del show
     */
    @Column(name="nom_show")
     private String nomShow;
    /**
     * Attr: Id del tipo de documento// Cambiar a tipo de documento para relacionarlo
     */
    @ManyToOne
     @JoinColumn(name = "id_tipo_documento")
     private TipoDocumentoEntity tipoDocumento;
    /**
     * Attr: Id del documento// Cambiar a tipo de id para relacionarlos
     */
    @ManyToOne
     @JoinColumn(name = "id_documento_encargado")
     private DocumentoEntity idDocumento;
    /**
     * Attr: Id de la fecha y hora// Cambiar a llave compuesta relacionarlos
     */
    @ManyToOne
     @JoinColumn(name = "id_fecha_lugar")
     private FechaHoraEntity idFecHo;

    public ShowEntity() {
    }

    public long getIdShow() {
        return idShow;
    }

    public ZooEntity getIdZoo() {
        return idZoo;
    }

    public String getNomShow() {
        return nomShow;
    }

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public DocumentoEntity getIdDocumento() {
        return idDocumento;
    }

    public FechaHoraEntity getIdFecHo() {
        return idFecHo;
    }

    public void setIdShow(long idShow) {
        this.idShow = idShow;
    }

    public EncargadoEntity getIdEncargado() {
        return idEncargado;
    }

    public void setIdZoo(ZooEntity idZoo) {
        this.idZoo = idZoo;
    }

    public void setNomShow(String nomShow) {
        this.nomShow = nomShow;
    }

    public void setIdEncargado(EncargadoEntity idEncargado) {
        this.idEncargado = idEncargado;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setIdDocumento(DocumentoEntity idDocumento) {
        this.idDocumento = idDocumento;
    }
    

    public void setIdFecHo(FechaHoraEntity idFecHo) {
        this.idFecHo = idFecHo;
    }
    
    
}
