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
import co.edu.konrad.zoologico.Entities.EncargadoEntity;
import co.edu.konrad.zoologico.persistence.EncargadoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EncargadoLogic {

    @Inject
    private EncargadoPersistence persistence;

    /**
     * Metodo para obtener todos los encargados
     *
     * @return
     */
    public List<EncargadoEntity> obtenerEncargado() {
        List<EncargadoEntity> encargado = persistence.findAll();
        return encargado;
    }

    /**
     * Metodo para retornar por id
     *
     * @param id
     * @return
     */
    public EncargadoEntity obtenerEncargadoPorId(int id) {
        EncargadoEntity encargado = persistence.find(id);
        if (encargado == null) {
            throw new IllegalArgumentException("Encargado Solicitado no existe");
        }
        return encargado;
    }

    /**
     * metodo para crear un encargado
     *
     * @param entity
     * @return
     */
    public EncargadoEntity crearEncargado(EncargadoEntity entity) {
        persistence.insert(entity);
        return entity;
    }

    /**
     * Actualizar un encargado
     *
     * @param entity
     * @param id
     * @return
     */
    public EncargadoEntity actualizarEncargado(EncargadoEntity entity, int id) {
        EncargadoEntity encargado = persistence.update(entity);
        return encargado;
    }

    /**
     * eliminar un encargado
     *
     * @param id
     */
    public void eliminarEncargado(int id) {
        persistence.delete(id);
    }
}
