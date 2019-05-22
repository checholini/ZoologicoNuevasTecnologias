/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.DTO;

import co.edu.konrad.zoologico.Entities.DocumentoEntity;
import co.edu.konrad.zoologico.Entities.EncargadoEntity;
import co.edu.konrad.zoologico.Entities.FechaHoraEntity;
import co.edu.konrad.zoologico.Entities.ShowEntity;
import co.edu.konrad.zoologico.Entities.TipoDocumentoEntity;
import co.edu.konrad.zoologico.Entities.ZooEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio S. Salcedo T.
 */
public class ShowDTO {
    
    private long idShow;
    
    private EncargadoEntity idEncargado;
    
    private ZooEntity idZoo;
    
    private String nomShow;
    
    private TipoDocumentoEntity tipoDocumento;
    
    private DocumentoEntity idDocumento;
    
    private FechaHoraEntity idFecHo;

    public ShowDTO() {
    }
    /**
     * de entity a DTO
     * @param entity 
     */
    public ShowDTO(ShowEntity entity) {
        this.idShow = entity.getIdShow();
        this.idEncargado = entity.getIdEncargado();
        this.idZoo = entity.getIdZoo();
        this.nomShow = entity.getNomShow();
        this.tipoDocumento = entity.getTipoDocumento();
        this.idDocumento = entity.getIdDocumento();
        this.idFecHo = entity.getIdFecHo();
    }
    /**
     * lista de shows
     * @param Show
     * @return 
     */
    public static List<ShowDTO> toShowList(List<ShowEntity> Show){
      List<ShowDTO> listaShow = new ArrayList();
      for(int i = 0; i <Show.size();i++){
          listaShow.add(new ShowDTO(Show.get(i)));
      }
      return listaShow;
    }
    /**
     * de DTO a entity
     * @return 
     */
    public ShowEntity toEntity(){
        ShowEntity entity = new ShowEntity();
        entity.setIdDocumento(this.idDocumento);
        entity.setIdEncargado(this.idEncargado);
        entity.setIdFecHo(this.idFecHo);
        entity.setIdShow(this.idShow);
        entity.setIdZoo(this.idZoo);
        entity.setNomShow(this.nomShow);
        entity.setTipoDocumento(this.tipoDocumento);
        
        return entity;
    }

    public long getIdShow() {
        return idShow;
    }

    public EncargadoEntity getIdEncargado() {
        return idEncargado;
    }

    public ZooEntity getIdZoo() {
        return idZoo;
    }

    public String getNomShow() {
        return nomShow;
    }

    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }

    public DocumentoEntity getIdDocumento() {
        return idDocumento;
    }

    public FechaHoraEntity getIdFecHo() {
        return idFecHo;
    }

    public void setIdShow(long idShow) {
        this.idShow = idShow;
    }

    public void setIdEncargado(EncargadoEntity idEncargado) {
        this.idEncargado = idEncargado;
    }

    public void setIdZoo(ZooEntity idZoo) {
        this.idZoo = idZoo;
    }

    public void setNomShow(String nomShow) {
        this.nomShow = nomShow;
    }

    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setIdDocumento(DocumentoEntity idDocumento) {
        this.idDocumento = idDocumento;
    }

    public void setIdFecHo(FechaHoraEntity idFecHo) {
        this.idFecHo = idFecHo;
    }
    
    
}
