/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.FechaHoraEntity;
import co.edu.konrad.zoologico.Entities.RatingShowEntity;
import co.edu.konrad.zoologico.Entities.ShowEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio S. Salcedo T.
 */
public class RatingShowDTO {
    
    private Long idRatingShow;
    
    private ShowEntity idShow;
    
     private Long rating;
     
     private String comentario;
     
     private FechaHoraEntity idFecHo;

    public RatingShowDTO() {
    }
    
    /**
     * de entity a DTO
     * @param entity 
     */
    public RatingShowDTO(RatingShowEntity entity) {
        this.idRatingShow = entity.getIdRatingShow();
        this.idShow = entity.getIdShow();
        this.rating = entity.getRating();
        this.comentario = entity.getComentario();
        this.idFecHo = entity.getIdFecHo();
    }
    /**
     * lista de rating show
     * @param RShow
     * @return 
     */
    public static List<RatingShowDTO> toShowList(List<RatingShowEntity> RShow){
      List<RatingShowDTO> listaRShow = new ArrayList();
      for(int i = 0; i <RShow.size();i++){
          listaRShow.add(new RatingShowDTO(RShow.get(i)));
      }
      return listaRShow;
    }
     
    /**
     * De DTO a Entity
     * @return 
     */
    public RatingShowEntity toEntity(){
        RatingShowEntity entity = new RatingShowEntity();
        entity.setIdRatingShow(this.idRatingShow);
        entity.setIdShow(this.idShow);
        entity.setIdFecHo(this.idFecHo);
        entity.setRating(this.rating);
        entity.setComentario(this.comentario);
        
        return entity;
    }

    public Long getIdRatingShow() {
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

    public void setIdRatingShow(Long idRatingShow) {
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
