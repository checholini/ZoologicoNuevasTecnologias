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
    
    private Long idCuidador;
    
    private String fechaNacimientoCuidador;
    
    private DocumentoEntity idDocumento;
    

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
        cuidadorEntity.setIdCuidador(this.idCuidador);
        return cuidadorEntity;
    }

    public Long getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(Long idCuidador) {
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
