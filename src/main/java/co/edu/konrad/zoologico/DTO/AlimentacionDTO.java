/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.AlimentacionEntity;
import co.edu.konrad.zoologico.Entities.AnimalEntity;

/**
 *
 * @author SergioRodriguez
 */
public class AlimentacionDTO {
    /**
    * Atributo Id
    */
    private int idAlimentacion;
    
    /**
    * Atributo nombre
    */
    private String nombreAlimento;
    
    /**
    * Atributo cantidad
    */
    private String cantidadAlimento;
    
    /**
    * Atributo horario dia
    */
    private String horarioMañana;
    
    /**
    * Atributo horario tarde
    */
    private String horarioTarde;

    /**
     * Constructor vacio
     */
    public AlimentacionDTO() {
    }
    
    /**
     * Entity to DTO
     * @param alimentacion Objeto tipo AlimentacionEntity
     */
    public AlimentacionDTO(AlimentacionEntity alimentacion) {
        this.idAlimentacion = alimentacion.getIdAlimentacion();
        this.nombreAlimento = alimentacion.getNombreAlimento();
        this.cantidadAlimento = alimentacion.getCantidadAlimento();
        this.horarioMañana = alimentacion.getHorarioMañana();
        this.horarioTarde = alimentacion.getHorarioTarde();
    }
    
    
    /**
     * DTO to Entity
     * @return alimentacion Objeto tipo alimenrtacionEntity
     */
    public AlimentacionEntity toEntity(){
        AlimentacionEntity alimentacion = new AlimentacionEntity();
        alimentacion.setCantidadAlimento(this.cantidadAlimento);
        alimentacion.setHorarioMañana(this.horarioMañana);
        alimentacion.setHorarioTarde(this.horarioTarde);
        alimentacion.setIdAlimentacion(this.idAlimentacion);
        alimentacion.setNombreAlimento(this.nombreAlimento);
        return alimentacion;
    }
       
}
