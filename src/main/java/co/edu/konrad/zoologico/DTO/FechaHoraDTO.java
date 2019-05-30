/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.FechaHoraEntity;
import co.edu.konrad.zoologico.Entities.LugarEntity;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio S. Salcedo T.
 */
public class FechaHoraDTO {
    
    private long idFecHo;
    
     private LugarEntity idLugar;
     
      private String fecha;
      
      private String hora;
      
    public FechaHoraDTO() {
    }
    /**
     *  de entity a DTO
     * @param entity 
     */
    public FechaHoraDTO(FechaHoraEntity entity) {
        this.idFecHo = entity.getIdFecHo();
        this.idLugar = entity.getIdLugar();
        this.fecha = entity.getFecha();
        this.hora=entity.getHora();
    }
    /**
     * devuelve lista de fechas y horas
     * @param FH
     * @return 
     */
     public static List<FechaHoraDTO> toFHList(List<FechaHoraEntity> FH){
      List<FechaHoraDTO> listaFH = new ArrayList();
      for(int i = 0; i <FH.size();i++){
          listaFH.add(new FechaHoraDTO(FH.get(i)));
      }
      return listaFH;
    }
     /**
      * de DTO a Entity
      * @return 
      */
      public FechaHoraEntity toEntity(){
        FechaHoraEntity Entity = new FechaHoraEntity();
       Entity.setIdFecHo(this.idFecHo);
       Entity.setFecha(this.fecha);
       Entity.setHora(this.hora);
       Entity.setIdLugar(this.idLugar);
        return Entity;
    }

    public long getIdFecHo() {
        return idFecHo;
    }

    public LugarEntity getIdLugar() {
        return idLugar;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setIdFecHo(long idFecHo) {
        this.idFecHo = idFecHo;
    }

    public void setIdLugar(LugarEntity idLugar) {
        this.idLugar = idLugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
