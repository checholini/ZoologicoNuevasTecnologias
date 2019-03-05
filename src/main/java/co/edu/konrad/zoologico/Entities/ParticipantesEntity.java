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
@Table(name = "Participantes")
public class ParticipantesEntity implements Serializable{

    /**
     * Llave primaria de participantes
     */
    @Id
    @Column(name = "id_participantes")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParticipantes;
    /**
     * Attr: Id de animal
     */
    @ManyToOne
    @JoinColumn(name = "id_Animal")
    private ZooEntity idAnimal;
    /**
     * Attr: Id de show
     */
    @ManyToOne
    @JoinColumn(name = "id_Show")
    private ShowEntity idShow;

    public ParticipantesEntity() {
    
    }

    public Long getIdParticipantes() {
        return idParticipantes;
    }

    public void setIdParticipantes(Long idParticipantes) {
        this.idParticipantes = idParticipantes;
    }

    public ZooEntity getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(ZooEntity idAnimal) {
        this.idAnimal = idAnimal;
    }

    public ShowEntity getIdShow() {
        return idShow;
    }

    public void setIdShow(ShowEntity idShow) {
        this.idShow = idShow;
    }

}
