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
    private Long idFecHo;
     /**
      * Attr: Id del lugar
      */
     @ManyToOne
     @JoinColumn(name = "id_lugar")
     private LugarEntity idLugar;
     /**
      * Attr: fecha
      */
     @Column
     private Date fecha;
     /**
      * Attr: hora
      */
     @Column
     private Time hora;

    public FechaHoraEntity() {
    }

    public Long getIdFecHo() {
        return idFecHo;
    }

    public LugarEntity getIdLugar() {
        return idLugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setIdFecHo(Long idFecHo) {
        this.idFecHo = idFecHo;
    }

    public void setIdLugar(LugarEntity idLugar) {
        this.idLugar = idLugar;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
     
     
}
