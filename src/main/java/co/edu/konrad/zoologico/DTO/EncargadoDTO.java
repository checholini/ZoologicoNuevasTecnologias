/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;



import co.edu.konrad.zoologico.Entities.DocumentoEntity;
import co.edu.konrad.zoologico.Entities.EncargadoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Ortiz.
 */
public class EncargadoDTO {
    
    private long idEncargado;
    
    private String telefonoEncargado;
    private String nombreEncargado;    
     private DocumentoEntity idDocumento;
    

    public EncargadoDTO() {
    }
    
    /**
     * De Entity a DTO
     * @param Encargado 
     */
    public EncargadoDTO(EncargadoEntity encargado) {
        this.idEncargado = encargado.getIdEncargado();
        this.telefonoEncargado = encargado.getTelefonoEncargado();
        this.idDocumento = encargado.getIdDocumento();
        this.nombreEncargado = encargado.getNomEncargado();
    }
    
    /**
     * Devuelve la lista de encargados
     * @param Encargado
     * @return 
     */
        public static List<EncargadoDTO> toZooList(List<EncargadoEntity> encargado){
      List<EncargadoDTO> listaEncargados = new ArrayList();
      for(int i = 0; i <encargado.size();i++){
          listaEncargados.add(new EncargadoDTO(encargado.get(i)));
      }
      return listaEncargados;
    }
    /**
     * de DTO a Entity
     * @return 
     */
    public EncargadoEntity toEntity(){
        EncargadoEntity encargadoEntity = new EncargadoEntity();
        encargadoEntity.setIdEncargado(this.idEncargado);
        encargadoEntity.setTelefonoEncargado(this.telefonoEncargado);
        encargadoEntity.setIdDocumento(this.idDocumento);
        encargadoEntity.setNomEncargado(this.nombreEncargado);
        return encargadoEntity;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }
    
    public long getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(long idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getTelefonoEncargado() {
        return telefonoEncargado;
    }

    public void setTelefonoEncargado(String telefonoEncargado) {
        this.telefonoEncargado = telefonoEncargado;
    }

    public DocumentoEntity getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(DocumentoEntity idDocumento) {
        this.idDocumento = idDocumento;
    }

    

    
}