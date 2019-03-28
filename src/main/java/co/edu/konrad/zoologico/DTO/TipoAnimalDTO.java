/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.TipoAnimalEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SergioRodriguez
 */
public class TipoAnimalDTO {
    /**
    * LAtributo id
    */
    private int idTipoAnimal;
    
    /**
    * Atributo nombre
    */
    private String nombreTipoAnimal;

    /**
     * Constructor vacio
     */
    public TipoAnimalDTO() {
    }

    /**
     * Entity to DTO
     * @param tipoAnimal Entidad de tipo animal
     */
    public TipoAnimalDTO(TipoAnimalEntity tipoAnimal) {
        this.idTipoAnimal = tipoAnimal.getIdTipoAnimal();
        this.nombreTipoAnimal = tipoAnimal.getNombreTipoAnimal();
    }
    
    /**
     * DTO to Entity
     * @return Entidad de tipo TipoAnimalEntity
     */
    public TipoAnimalEntity toEntity(){
        TipoAnimalEntity tipoAnimal = new TipoAnimalEntity();
        tipoAnimal.setIdTipoAnimal(this.idTipoAnimal);
        tipoAnimal.setNombreTipoAnimal(this.nombreTipoAnimal);
        return tipoAnimal;
    }
    
    /**
     * Metodo para retornar una lista de Tipo de Animales
     * @param tipoAnimalList Lista de Entities
     * @return Lista de DTO 
     */
    public static List<TipoAnimalDTO> toTipoAnimalList(List<TipoAnimalEntity> tipoAnimalList){
        List<TipoAnimalDTO> listaTipoAnimal = new ArrayList<>();
        for(int i = 0; i<tipoAnimalList.size(); i++){
            listaTipoAnimal.add(new TipoAnimalDTO(tipoAnimalList.get(i)));
        }
        return listaTipoAnimal;
    }
    
    /*
     * Getters y Setters
     */

    public int getIdTipoAnimal() {
        return idTipoAnimal;
    }

    public void setIdTipoAnimal(int idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public String getNombreTipoAnimal() {
        return nombreTipoAnimal;
    }

    public void setNombreTipoAnimal(String nombreTipoAnimal) {
        this.nombreTipoAnimal = nombreTipoAnimal;
    }
    
}
