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
import javax.persistence.Table;

/**
 * Creacion Tabla Animal 
 * @author SergioRodriguez
 * 
 */
@Entity
@Table(name = "animal")
public class AnimalEntity implements Serializable{
    /**
    * Llave primaria
    */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAnimal;
    
    /**
    * Llave foranea Zoo
    */
    @ManyToOne
    @JoinColumn(name = "id_zoo")
    private ZooEntity idZoo;    
    
    /**
    * Llave foranea tipo animal
    */
    @ManyToOne
    @JoinColumn(name = "id_tipo_animal")
    private TipoAnimalEntity idTipoAnimal;    
    
    /**
    * Llave Foranea Alimentacion
    */
    @ManyToOne
    @JoinColumn(name = "id_alimentacion")
    private AlimentacionEntity idAlimentacion ;
    
    /**
    * Llave Foranea Cuidador
    */
    @ManyToOne
    @JoinColumn(name = "id_cuidador")
    private CuidadorEntity idCuidador;
    
    /**
    * Atributo Nombre
    */
    @Column(name = "nom_animal")
    private String nombre;
    
    /**
    * Atributo nombre cientifico
    */
    @Column(name = "nom_cientifico_animal")
    private String nombreCientificoAnimal;
    
    /**
    * Atributo Descripcion 
    */
    @Column(name = "desc_animal")
    private String descripcionAnimal;
    
    /**
    * Atributo especie
    */
    @Column(name = "especie_animal")
    private String especieAnimal;
    
    /*
     * Getters y setters
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




