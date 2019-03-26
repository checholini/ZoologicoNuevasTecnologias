/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoologico.logic;

/**
 *
 * @author Oscar Ortiz.
 */
import co.edu.konrad.zoologico.Entities.ParticipantesEntity;
import co.edu.konrad.zoologico.persistence.ParticipantesPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ParticipantesLogic {

    @Inject
    private ParticipantesPersistence persistence;

    /**
     * Metodo para obtener todos los participantes
     *
     * @return
     */
    public List<ParticipantesEntity> obtenerParticipantes() {
        List<ParticipantesEntity> participantes = persistence.findAll();
        return participantes;
    }

    /**
     * Metodo para retornar por id
     *
     * @param id
     * @return
     */
    public ParticipantesEntity obtenerParticipantePorId(int id) {
        ParticipantesEntity participante = persistence.find(id);
        if (participante == null) {
            throw new IllegalArgumentException("Participante Solicitado no existe");
        }
        return participante;
    }

    /**
     * metodo para crear un participante
     *
     * @param entity
     * @return
     */
    public ParticipantesEntity crearParticipante(ParticipantesEntity entity) {
        persistence.insert(entity);
        return entity;
    }

    /**
     * Actualizar un participante
     *
     * @param entity
     * @param id
     * @return
     */
    public ParticipantesEntity actualizarParticipante(ParticipantesEntity entity, int id) {
        ParticipantesEntity participante = persistence.update(entity);
        return participante;
    }

    /**
     * eliminar un participante
     *
     * @param id
     */
    public void eliminarParticipante(int id) {
        persistence.delete(id);
    }
}
