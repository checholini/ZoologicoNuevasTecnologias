/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;


import co.edu.konrad.zoologico.Entities.CuidadorEntity;
import co.edu.konrad.zoologico.Entities.DocumentoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Ortiz.
 */
public class CuidadorDTO {
    
    private long idCuidador;
    
    private String fechaNacimientoCuidador;
    private DocumentoEntity idDocumento;
    private String nombreCuidador;
    

    public CuidadorDTO() {
    }
    
    /**
     * De Entity a DTO
     * @param cuidador 
     */
    public CuidadorDTO(CuidadorEntity cuidador) {
        this.idCuidador = cuidador.getIdCuidador();
        this.fechaNacimientoCuidador = cuidador.getFechaNacimientoCuidador();
        this.idDocumento = cuidador.getIdDocumento();
        this.nombreCuidador = cuidador.getNombreCuidador();
    }
    
    /**
     * Devuelve la lista de cuidador
     * @param cuidador
     * @return 
     */
        public static List<CuidadorDTO> toZooList(List<CuidadorEntity> cuidador){
      List<CuidadorDTO> listaCuidadores = new ArrayList();
      for(int i = 0; i <cuidador.size();i++){
          listaCuidadores.add(new CuidadorDTO(cuidador.get(i)));
      }
      return listaCuidadores;
    }
    /**
     * de DTO a Entity
     * @return 
     */
    public CuidadorEntity toEntity(){
        CuidadorEntity cuidadorEntity = new CuidadorEntity();
        cuidadorEntity.setIdCuidador(this.idCuidador);
        cuidadorEntity.setFechaNacimientoCuidador(this.fechaNacimientoCuidador);
        cuidadorEntity.setIdDocumento(this.idDocumento);
        cuidadorEntity.setNombreCuidador(this.nombreCuidador);
        return cuidadorEntity;
    }

    public String getNombreCuidador() {
        return nombreCuidador;
    }

    public void setNombreCuidador(String nombreCuidador) {
        this.nombreCuidador = nombreCuidador;
    }

    public long getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(long idCuidador) {
        this.idCuidador = idCuidador;
    }

    public String getFechaNacimientoCuidador() {
        return fechaNacimientoCuidador;
    }

    public void setFechaNacimientoCuidador(String fechaNacimientoCuidador) {
        this.fechaNacimientoCuidador = fechaNacimientoCuidador;
    }

    public DocumentoEntity getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(DocumentoEntity idDocumento) {
        this.idDocumento = idDocumento;
    }

}
