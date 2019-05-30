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

/**
 * Creacion tabla rating animal
 * @author SergioRodriguez
 */
@Entity
public class RatingAnimalEntity implements Serializable{
    
    /**
    * Creacion llave primaria
    */ 
    @Id
    @Column(name = "id_rating_animal")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRatingAnimal;
    
    /**
    * Creacion llave foranea animal
    */
    @ManyToOne
    @JoinColumn(name = "id_animal_fk")
    private AnimalEntity idAnimal;
    
    /**
    * Atributo calificacion
    */
    @Column(name = "calficacion_animal")
    private byte calificacionAnimal;
    
    /**
    * Atributo comentario
    */
    @Column(name = "comentario_animal")
    private String comentarioAnimal;

    /**
    * Constructor clase
    */
    public RatingAnimalEntity() {
    } 
    
    /*
    * Getters y Setters
    */

    public long getIdRatingAnimal() {
        return idRatingAnimal;
    }

    public void setIdRatingAnimal(long idRatingAnimal) {
        this.idRatingAnimal = idRatingAnimal;
    }

    public AnimalEntity getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(AnimalEntity idAnimal) {
        this.idAnimal = idAnimal;
    }

    public byte getCalificacionAnimal() {
        return calificacionAnimal;
    }

    public void setCalificacionAnimal(byte calificacionAnimal) {
        this.calificacionAnimal = calificacionAnimal;
    }

    public String getComentarioAnimal() {
        return comentarioAnimal;
    }

    public void setComentarioAnimal(String comentarioAnimal) {
        this.comentarioAnimal = comentarioAnimal;
    }
    
    
    
}
