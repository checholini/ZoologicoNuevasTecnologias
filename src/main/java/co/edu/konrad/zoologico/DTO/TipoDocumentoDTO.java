
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;


import co.edu.konrad.zoologico.Entities.TipoDocumentoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Ortiz.
 */
public class TipoDocumentoDTO {
    
    private long idTipoDocumento;
    
    private String nom_tipo_documento;
    

    public TipoDocumentoDTO() {
    }
    
    /**
     * De Entity a DTO
     * @param TipoDocumento 
     */
    public TipoDocumentoDTO(TipoDocumentoEntity tipoDocumento) {
        this.idTipoDocumento = tipoDocumento.getIdTipoDocumento();
        this.nom_tipo_documento = tipoDocumento.getNom_tipo_documento();
        
    }
    
    /**
     * Devuelve la lista de tipo de documento
     * @param TipoDocumento
     * @return 
     */
        public static List<TipoDocumentoDTO> toZooList(List<TipoDocumentoEntity> tipoDocumento){
      List<TipoDocumentoDTO> listaTipoDocumentos = new ArrayList();
      for(int i = 0; i <tipoDocumento.size();i++){
          listaTipoDocumentos.add(new TipoDocumentoDTO(tipoDocumento.get(i)));
      }
      return listaTipoDocumentos;
    }
    /**
     * de DTO a Entity
     * @return 
     */
    public TipoDocumentoEntity toEntity(){
        TipoDocumentoEntity TipoDocumentoEntity = new TipoDocumentoEntity();
        TipoDocumentoEntity.setIdTipoDocumento(this.idTipoDocumento);
        TipoDocumentoEntity.setNom_tipo_documento(this.nom_tipo_documento);
        
        return TipoDocumentoEntity;
    }

    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNom_tipo_documento() {
        return nom_tipo_documento;
    }

    public void setNom_tipo_documento(String nom_tipo_documento) {
        this.nom_tipo_documento = nom_tipo_documento;
    }

   
    
}