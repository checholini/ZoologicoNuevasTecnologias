/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.Entities;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author Oscar Ortiz
 */
@Entity
@Table(name = "Ciudador")
public class CuidadorEntity implements Serializable{
    /**
     * Llave primaria de cuidador
     */
    @Id
    @Column(name = "id_cuidador")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCuidador;
    /**
     * Attr: Dia de fecha de nacimiento del cuidador
     */
    @Column(name = "f_nacimiento_cuidador")
    private String fechaNacimientoCuidador;
    
    /**
     * Attr: id tipo de documento
     */
    @ManyToOne
    @JoinColumn(name = "id_documento")
    private DocumentoEntity idDocumento;

    public CuidadorEntity() {
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
