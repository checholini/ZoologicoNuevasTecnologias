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
import java.util.ArrayList;
import java.util.List;

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
       animal.setNombre(this.nombre);
       return animal;
   }
    
   /**
     * Metodo para retornar una lista de Animales
     * @param animalList Lista de Entities
     * @return Lista de DTO 
     */
    public static List<AnimalDTO> toAnimalList(List<AnimalEntity> animalList){
        List<AnimalDTO> listaAnimales = new ArrayList<>();
        for(int i = 0; i<animalList.size(); i++){
            listaAnimales.add(new AnimalDTO(animalList.get(i)));
        }
        return listaAnimales;
    }
    
    /*
     * Getters y Setters
     */

    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public ZooEntity getIdZoo() {
        return idZoo;
    }

    public void setIdZoo(ZooEntity idZoo) {
        this.idZoo = idZoo;
    }

    public TipoAnimalEntity getIdTipoAnimal() {
        return idTipoAnimal;
    }

    public void setIdTipoAnimal(TipoAnimalEntity idTipoAnimal) {
        this.idTipoAnimal = idTipoAnimal;
    }

    public AlimentacionEntity getIdAlimentacion() {
        return idAlimentacion;
    }

    public void setIdAlimentacion(AlimentacionEntity idAlimentacion) {
        this.idAlimentacion = idAlimentacion;
    }

    public CuidadorEntity getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(CuidadorEntity idCuidador) {
        this.idCuidador = idCuidador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientificoAnimal() {
        return nombreCientificoAnimal;
    }

    public void setNombreCientificoAnimal(String nombreCientificoAnimal) {
        this.nombreCientificoAnimal = nombreCientificoAnimal;
    }

    public String getDescripcionAnimal() {
        return descripcionAnimal;
    }

    public void setDescripcionAnimal(String descripcionAnimal) {
        this.descripcionAnimal = descripcionAnimal;
    }

    public String getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(String especieAnimal) {
        this.especieAnimal = especieAnimal;
    }
        
}
