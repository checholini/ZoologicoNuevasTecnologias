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
import co.edu.konrad.zoologico.Entities.CuidadorEntity;
import co.edu.konrad.zoologico.persistence.CuidadorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CuidadorLogic {

    @Inject
    private CuidadorPersistence persistence;

    /**
     * Metodo para obtener todos los cuidador
     *
     * @return
     */
    public List<CuidadorEntity> obtenerCuidador() {
        List<CuidadorEntity> cuidador = persistence.findAll();
        return cuidador;
    }

    /**
     * Metodo para retornar por id
     *
     * @param id
     * @return
     */
    public CuidadorEntity obtenerCuidadorPorId(int id) {
        CuidadorEntity cuidador = persistence.find(id);
        if (cuidador == null) {
            throw new IllegalArgumentException("Cuidador Solicitado no existe");
        }
        return cuidador;
    }

    /**
     * metodo para crear un cuidador
     *
     * @param entity
     * @return
     */
    public CuidadorEntity crearCuidador(CuidadorEntity entity) {
        persistence.insert(entity);
        return entity;
    }

    /**
     * Actualizar un cuidador
     *
     * @param entity
     * @param id
     * @return
     */
    public CuidadorEntity actualizarCuidador(CuidadorEntity entity, int id) {
        CuidadorEntity cuidador = persistence.update(entity);
        return cuidador;
    }

    /**
     * eliminar un cuidador
     *
     * @param id
     */
    public void eliminarCuidador(int id) {
        persistence.delete(id);
    }
}

