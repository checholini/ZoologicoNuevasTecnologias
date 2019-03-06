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
 * Creacion Tabla Alimentacion
 * @author SergioRodriguez
 */
@Entity
@Table(name = "alimentacion")
public class AlimentacionEntity implements Serializable{
    /**
    * Llave primaria
    */
    @Id
    @Column(name = "id_alimentacion")
    private int idAlimentacion;
    
    /**
    * Atributo nombre
    */
    @Column(name = "nom_alimento")
    private String nombreAlimento;
    
    /**
    * Atributo cantidad
    */
    @Column(name = "cantidad_alimento")
    private String cantidadAlimento;
    
    /**
    * Atributo horario dia
    */
    @Column(name = "horario_mañana")
    private String horarioMañana;
    
    /**
    * Atributo horario tarde
    */
    @Column(name = "horario_tarde")
    private String horarioTarde;

    /**
    * Constructor 
    */
    public AlimentacionEntity() {
    }
    
    /*
    * Getters y Setters
    */

    public int getIdAlimentacion() {
        return idAlimentacion;
    }

    public void setIdAlimentacion(int idAlimentacion) {
        this.idAlimentacion = idAlimentacion;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public String getCantidadAlimento() {
        return cantidadAlimento;
    }

    public void setCantidadAlimento(String cantidadAlimento) {
        this.cantidadAlimento = cantidadAlimento;
    }

    public String getHorarioMañana() {
        return horarioMañana;
    }

    public void setHorarioMañana(String horarioMañana) {
        this.horarioMañana = horarioMañana;
    }

    public String getHorarioTarde() {
        return horarioTarde;
    }

    public void setHorarioTarde(String horarioTarde) {
        this.horarioTarde = horarioTarde;
    }

    
    
}