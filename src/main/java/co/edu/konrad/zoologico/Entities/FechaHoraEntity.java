/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.Entities;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Sergio S. Salcedo T 
 */
@Entity
@Table(name="Fecha_Hora")
public class FechaHoraEntity implements Serializable {
    /**
     * Llave primaria temporal mientras descubrimos como hacer llaves compuestas
     */
     @Id
    @Column(name = "id_Fecha_Hora")
   @GeneratedValue(strategy= GenerationType.AUTO)
    private long idFecHo;
     /**
      * Attr: Id del lugar
      */
     @ManyToOne
     @JoinColumn(name = "idLugar")
     private LugarEntity idLugar;
     /**
      * Attr: fecha
      */
     @Column
     private String fecha;
     /**
      * Attr: hora
      */
     @Column
     private String hora;

    public FechaHoraEntity() {
    }

    public long getIdFecHo() {
        return idFecHo;
    }

    public LugarEntity getIdLugar() {
        return idLugar;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setIdFecHo(long idFecHo) {
        this.idFecHo = idFecHo;
    }

    public void setIdLugar(LugarEntity idLugar) {
        this.idLugar = idLugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
     
     
}
