/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.AnimalEntity;
import co.edu.konrad.zoologico.Entities.RatingAnimalEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SergioRodriguez
 */
public class RatingAnimalDTO {
    /**
    * Atributo id
    */
    private long idRatingAnimal;
    
    /**
    * Atrbuto animal
    */
    private AnimalEntity idAnimal;
    
    /**
    * Atributo calificacion
    */
    private byte calificacionAnimal;
    
    /**
    * Atributo comentario
    */
    private String comentarioAnimal;

    /**
    * Constructor Vacio
    */
    public RatingAnimalDTO() {
    } 

    /**
     * Entity to DTO
     * @param ratingAnimal Entidad tipo RatingAnimal
     */
    public RatingAnimalDTO(RatingAnimalEntity ratingAnimal) {
        this.idRatingAnimal = ratingAnimal.getIdRatingAnimal();
        this.idAnimal = ratingAnimal.getIdAnimal();
        this.calificacionAnimal = ratingAnimal.getCalificacionAnimal();
        this.comentarioAnimal = ratingAnimal.getComentarioAnimal();
    }
    
    /**
     * DTO to Entity
     * @return RatingAnimalEntity
     */
    public RatingAnimalEntity toEntity(){
        RatingAnimalEntity ratingAnimal = new RatingAnimalEntity();
        ratingAnimal.setCalificacionAnimal(this.calificacionAnimal);
        ratingAnimal.setComentarioAnimal(this.comentarioAnimal);
        ratingAnimal.setIdAnimal(this.idAnimal);
        ratingAnimal.setIdRatingAnimal(this.idRatingAnimal);
        return ratingAnimal;
    }
    
    /**
     * Metodo para retornar una lista de Ratings
     * @param ratingAnimalList Lista de Entities
     * @return Lista de DTO 
     */
    public static List<RatingAnimalDTO> toRatingAnimalList(List<RatingAnimalEntity> ratingAnimalList){
        List<RatingAnimalDTO> listaRatingsAnimal = new ArrayList<>();
        for(int i = 0; i<ratingAnimalList.size(); i++){
            listaRatingsAnimal.add(new RatingAnimalDTO(ratingAnimalList.get(i)));
        }
        return listaRatingsAnimal;
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
