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
 * @author Sergio S. Salcedo T .
 */
@Entity
@Table(name="Lugar")
public class LugarEntity implements Serializable{
     /**
     * Llave primaria del lugar
     */
   @Id
    @Column(name = "id_lugar")
   @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idLugar;
   /**
    * Attr: Nombre del lugar
    */
   @Column(name="nombre_Lugar")
   private String nomLugar;
   /**
    * Attr: dirección del lugar
    */
   
   @Column(name="direccion_lugar")
   private String direccionLugar;

    public LugarEntity() {
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
