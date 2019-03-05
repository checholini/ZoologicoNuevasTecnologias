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
    private Long idShow;
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
    @Column(name="tipo_documento")
     private Long tipoDocumento;
    /**
     * Attr: Id del documento// Cambiar a tipo de id para relacionarlos
     */
    @Column(name="id_documento")
     private Long idDocumento;
    
    @ManyToOne
     @JoinColumn(name = "id_fecha_lugar")
     private FechaHoraEntity idFecHo;

    public ShowEntity() {
    }

    public Long getIdShow() {
        return idShow;
    }

    public ZooEntity getIdZoo() {
        return idZoo;
    }

    public String getNomShow() {
        return nomShow;
    }

    public Long getTipoDocumento() {
        return tipoDocumento;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public FechaHoraEntity getIdFecHo() {
        return idFecHo;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
    }

    public void setIdZoo(ZooEntity idZoo) {
        this.idZoo = idZoo;
    }

    public void setNomShow(String nomShow) {
        this.nomShow = nomShow;
    }

    public void setTipoDocumento(Long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public void setIdFecHo(FechaHoraEntity idFecHo) {
        this.idFecHo = idFecHo;
    }
    
    
}
