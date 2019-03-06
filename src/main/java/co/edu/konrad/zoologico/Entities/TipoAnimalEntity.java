/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Creacion Tabla Tipo Animal
 * @author SergioRodriguez
 */

@Entity
@Table(name = "tipo_animal")
public class TipoAnimalEntity implements Serializable{
    /**
    * Llave primaria Tipo Animal
    */
    @Id
    @Column(name = "id_tipo_animal")
    private int idTipoAnimal;
    
    /**
    * Atributo nombre
    */
    @Column(name = "nom_tipo_animal")
    private String nombreTipoAnimal;
    
}
