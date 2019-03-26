/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.AnimalEntity;
import co.edu.konrad.zoologico.Entities.ShowEntity;
import co.edu.konrad.zoologico.Entities.ParticipantesEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Ortiz.
 */
public class ParticipanteDTO {
    
    private long idParticipante;
    
    private AnimalEntity idAnimal;
    
    private ShowEntity idShow;
    

    public ParticipanteDTO() {
    }
    
    /**
     * De Entity a DTO
     * @param Participante 
     */
    public ParticipanteDTO(ParticipantesEntity participante) {
        this.idParticipante = participante.getIdParticipantes();
        this.idAnimal = participante.getIdAnimal();
        this.idShow = participante.getIdShow();
    }
    
    /**
     * Devuelve la lista de participantes
     * @param Participante
     * @return 
     */
        public static List<ParticipanteDTO> toZooList(List<ParticipantesEntity> participantes){
      List<ParticipanteDTO> listaParticipantes = new ArrayList();
      for(int i = 0; i <participantes.size();i++){
          listaParticipantes.add(new ParticipanteDTO(participantes.get(i)));
      }
      return listaParticipantes;
    }
    /**
     * de DTO a Entity
     * @return 
     */
    public ParticipantesEntity toEntity(){
        ParticipantesEntity participanteEntity = new ParticipantesEntity();
        participanteEntity.setIdParticipantes(this.idParticipante);
        participanteEntity.setIdAnimal(this.idAnimal);
        participanteEntity.setIdShow(this.idShow);
        return participanteEntity;
    }

    public long getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(long idParticipante) {
        this.idParticipante = idParticipante;
    }

    public AnimalEntity getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(AnimalEntity idAnimal) {
        this.idAnimal = idAnimal;
    }

    public ShowEntity getIdShow() {
        return idShow;
    }

    public void setIdShow(ShowEntity idShow) {
        this.idShow = idShow;
    }

    
}