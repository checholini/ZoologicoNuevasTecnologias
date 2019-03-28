/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.AlimentacionEntity;
import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * Metodo para retornar una lista de Alimentacion
     * @param alimentacionList Lista de Entities
     * @return Lista de DTO 
     */
    public static List<AlimentacionDTO> toAlimentacionList(List<AlimentacionEntity> alimentacionList){
        List<AlimentacionDTO> listaAlimentacion = new ArrayList<>();
        for(int i = 0; i<alimentacionList.size(); i++){
            listaAlimentacion.add(new AlimentacionDTO(alimentacionList.get(i)));
        }
        return listaAlimentacion;
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
