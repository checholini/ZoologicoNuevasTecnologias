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
 * @author SergioRoodriguez
 * 
 */
@Entity
@Table(name = "animal")
public class AnimalEntity implements Serializable{
    /*
    * Llave primaria
    */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAnimal;
    
    /*
    * Llave foranea Zoo
    */
    @ManyToOne
    @JoinColumn(name = "id_zoo")
    private ZooEntity idZoo;    
    
    /*
    * Llave foranea tipo animal
    */
    @ManyToOne
    @JoinColumn(name = "id_tipo_animal")
    private TipoAnimalEntity idTipoAnimal;    
    
    /*
    * Llave Foranea Alimentacion
    */
    @ManyToOne
    @JoinColumn(name = "id_alimentacion")
    private AlimentacionEntity idAlimentacion ;
    
    /*
    * Llave Foranea Cuidador
    */
    @ManyToOne
    @JoinColumn(name = "id_cuidador")
    private CuidadorEntity idCuidador;
    
    /*
    * Atributo Nombre
    */
    @Column(name = "nom_animal")
    private String nombre;
    
    /*
    * Atributo nombre cientifico
    */
    @Column(name = "nom_cientifico_animal")
    private String nombreCientificoAnimal;
    
    /*
    * Atributo Descripcion 
    */
    @Column(name = "desc_animal")
    private String descripcionAnimal;
    
    /*
    * Atributo especie
    */
    @Column(name = "especie_animal")
    private String especieAnimal;
    
}




