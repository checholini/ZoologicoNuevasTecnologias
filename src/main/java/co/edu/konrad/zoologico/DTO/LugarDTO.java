/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.LugarEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio S. Salcedo T.
 */
public class LugarDTO {
    
    private Long idLugar;
    
    private String nomLugar;
    
    private String direccionLugar;

    public LugarDTO() {
    }
    
    /**
     * De Entity a DTO
     * @param lugar 
     */
    public LugarDTO(LugarEntity lugar) {
        this.idLugar = lugar.getIdLugar();
        this.nomLugar = lugar.getDireccionLugar();
        this.direccionLugar = lugar.getNomLugar();
    }
    
    /**
     * Devuelve la lista de lugares
     * @param lugar
     * @return 
     */
        public static List<LugarDTO> toZooList(List<LugarEntity> lugar){
      List<LugarDTO> listaLugar = new ArrayList();
      for(int i = 0; i <lugar.size();i++){
          listaLugar.add(new LugarDTO(lugar.get(i)));
      }
      return listaLugar;
    }
    /**
     * de DTO a Entity
     * @return 
     */
    public LugarEntity toEntity(){
        LugarEntity lugarEntity = new LugarEntity();
        lugarEntity.setIdLugar(this.idLugar);
        lugarEntity.setDireccionLugar(this.direccionLugar);
        lugarEntity.setNomLugar(this.nomLugar);
        return lugarEntity;
    }

    public Long getIdLugar() {
        return idLugar;
    }

    public String getNomLugar() {
        return nomLugar;
    }

    public String getDireccionLugar() {
        return direccionLugar;
    }

    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public void setNomLugar(String nomLugar) {
        this.nomLugar = nomLugar;
    }

    public void setDireccionLugar(String direccionLugar) {
        this.direccionLugar = direccionLugar;
    }
    
    
}
