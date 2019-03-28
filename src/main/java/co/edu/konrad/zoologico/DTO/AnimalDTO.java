/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.AlimentacionEntity;
import co.edu.konrad.zoologico.Entities.AnimalEntity;
import co.edu.konrad.zoologico.Entities.CuidadorEntity;
import co.edu.konrad.zoologico.Entities.TipoAnimalEntity;
import co.edu.konrad.zoologico.Entities.ZooEntity;

/**
 *
 * @author SergioRodriguez
 */
public class AnimalDTO {
    /**
    * Id
    */
    private long idAnimal;
    
    /**
    * Atributo Zoo
    */
    private ZooEntity idZoo;    
    
    /**
    * Atributo Llave foranea tipo animal
    */
    private TipoAnimalEntity idTipoAnimal;    
    
    /**
    * Atributo Alimentacion
    */
    private AlimentacionEntity idAlimentacion ;
    
    /**
    * Atributo Cuidador
    */
    private CuidadorEntity idCuidador;
    
    /**
    * Atributo Nombre
    */
    private String nombre;
    
    /**
    * Atributo nombre cientifico
    */
    private String nombreCientificoAnimal;
    
    /**
    * Atributo Descripcion 
    */
    private String descripcionAnimal;
    
    /**
    * Atributo especie
    */
    private String especieAnimal;

    /**
     * Constructor vacio
     */
    public AnimalDTO() {
    }
    
    /**
     * Entity to DTO
     * @param animal 
     */
    public AnimalDTO(AnimalEntity animal) {
        this.idAnimal = animal.getIdAnimal();
        this.idZoo = animal.getIdZoo();
        this.idTipoAnimal = animal.getIdTipoAnimal();
        this.idAlimentacion = animal.getIdAlimentacion();
        this.idCuidador = animal.getIdCuidador();
        this.nombre = animal.getNombre();
        this.nombreCientificoAnimal = animal.getNombreCientificoAnimal();
        this.descripcionAnimal = animal.getDescripcionAnimal();
        this.especieAnimal = animal.getEspecieAnimal();
    }
    
   /**
    * DTO to Entity
    * @return AnimalEntity
    */ 
   public AnimalEntity toEntity(){
       AnimalEntity animal = new AnimalEntity();
       animal.setDescripcionAnimal(this.descripcionAnimal);
       animal.setEspecieAnimal(this.especieAnimal);
       animal.setDescripcionAnimal(this.descripcionAnimal);
       animal.setIdAlimentacion(this.idAlimentacion);
       animal.setIdAnimal(this.idAnimal);
       animal.setIdCuidador(this.idCuidador);
       animal.setIdTipoAnimal(this.idTipoAnimal);
       animal.setIdZoo(this.idZoo);
       animal.setNombreCientificoAnimal(nombreCientificoAnimal);
       return animal;
   }
    
    
}
