/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.ZooEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio S. Salcedo T.
 */
public class ZooDTO {
    
     private long idZoo;
     
     private String nomZoo;

    public ZooDTO() {
    }
    /**
     * de Entity to Dto
     * @param zoo 
     */
    public ZooDTO(ZooEntity zoo) {
        this.idZoo = zoo.getIdZoo();
        this.nomZoo = zoo.getNomZoo();
    }
     /**
      * Devuelve la lista de zoologicos
      * @param zoo
      * @return listaZoo
      */
    public static List<ZooDTO> toZooList(List<ZooEntity> zoo){
      List<ZooDTO> listaZoo = new ArrayList();
      for(int i = 0; i <zoo.size();i++){
          listaZoo.add(new ZooDTO(zoo.get(i)));
      }
      return listaZoo;
    }
    /**
     * de DTO a Entity
     * @return 
     */
    public ZooEntity toEntity(){
        ZooEntity zooEntity = new ZooEntity();
       zooEntity.setIdZoo(this.idZoo);
       zooEntity.setNomZoo(this.nomZoo);
        return zooEntity;
    }

    public long getIdZoo() {
        return idZoo;
    }

    public String getNomZoo() {
        return nomZoo;
    }

    public void setIdZoo(long idZoo) {
        this.idZoo = idZoo;
    }

    public void setNomZoo(String nomZoo) {
        this.nomZoo = nomZoo;
    }
    
}
