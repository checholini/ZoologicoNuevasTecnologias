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
@Table(name="Rating_Show")
public class RatingShowEntity implements Serializable {
    /**
     * attr: Id del rating show
     */
    @Id
    @Column(name = "id_rating_show")
   @GeneratedValue(strategy= GenerationType.AUTO)
    private long idRatingShow;
    /**
     * attr: Id del show
     */
    @ManyToOne
    @JoinColumn(name = "id_show")
    private ShowEntity idShow;
    /**
     * attr: rating del show
     */
    @Column
    private Long rating;
    /**
     * attr: comentario del show
     */
    @Column
    private String comentario;
    /**
     * Attr: Id de la fecha y hora// Cambiar a llave compuesta relacionarlos
     */
    @ManyToOne
     @JoinColumn(name = "id_fecha_lugar")
     private FechaHoraEntity idFecHo;

    public RatingShowEntity() {
    }

    public long getIdRatingShow() {
        return idRatingShow;
    }

    public ShowEntity getIdShow() {
        return idShow;
    }

    public Long getRating() {
        return rating;
    }

    public String getComentario() {
        return comentario;
    }

    public FechaHoraEntity getIdFecHo() {
        return idFecHo;
    }

    public void setIdRatingShow(long idRatingShow) {
        this.idRatingShow = idRatingShow;
    }

    public void setIdShow(ShowEntity idShow) {
        this.idShow = idShow;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setIdFecHo(FechaHoraEntity idFecHo) {
        this.idFecHo = idFecHo;
    }
    
   
}
