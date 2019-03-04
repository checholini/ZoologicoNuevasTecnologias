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
import javax.persistence.Table;
/**
 *
 * @author Sergio S. Salcedo T.
 */
@Entity
@Table(name="Zoo")
public class ZooEntity implements Serializable {
    /**
     * Llave primaria del zoologico
     */
   @Id
    @Column(name = "id_zoo")
   @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idZoo;
   /**
    * Attr: Nombre del zoologico
    */
   @Column(name="nombre_zoo")
   private String nomZoo;

    public ZooEntity() {
    }

    public Long getIdZoo() {
        return idZoo;
    }

    public String getNomZoo() {
        return nomZoo;
    }

    public void setIdZoo(Long idZoo) {
        this.idZoo = idZoo;
    }

    public void setNomZoo(String nomZoo) {
        this.nomZoo = nomZoo;
    }
   
   
}
