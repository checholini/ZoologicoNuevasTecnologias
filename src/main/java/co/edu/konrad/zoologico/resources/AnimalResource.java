/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.konrad.zoologico.resources;

import co.edu.konrad.zoologico.DTO.AnimalDTO;
import co.edu.konrad.zoologico.Entities.AnimalEntity;
import co.edu.konrad.zoologico.logic.AnimalLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author $SergioRodriguez
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/animal")
public class AnimalResource {
    @EJB
    private AnimalLogic animal;

    /**
     * Metodo para retornar todos los datos de animal
     * @return List animalDTO
     */
    @GET
    public List<AnimalDTO> getAlimentancionList(){
        List<AnimalEntity> animales = animal.getAllanimales();
        return AnimalDTO.toAnimalList(animales);
    }

    /**
     * Obtiene un animal segun un id
     * @param id de Busqueda
     * @return animal Encontrado
     */
    @GET
    @Path("{id: \\d+}")
    public AnimalDTO getanimal(@PathParam("id") long id){
        AnimalEntity animalE = animal.getanimalById(id);
        if(animalE == null){
            throw new RuntimeException("El animal con id "+id+" no existe");
        }
        return new AnimalDTO(animalE);
    }

    /**
     * Metodo para crear una animal
     * @param animalDTO
     * @return
     */
    @POST
    public AnimalDTO createanimal(AnimalDTO animalDTO){
        return new AnimalDTO(animal.createAnimal(animalDTO.toEntity()));
    }

    /**
     * Actualiza un alimento
     * @param id
     * @param animalDTO
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public AnimalDTO updateanimal(@PathParam("id") int id, AnimalDTO animalDTO){
        AnimalEntity animalE = animal.getanimalById(id);
        if(animalE == null){
            throw new RuntimeException("El animal con id "+id+" no existe");
        }
        return new AnimalDTO(animal.updateAnimal(animalDTO.toEntity(),id));
    }

    /**
     * Metodo para eliminar una animal
     * @param id
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProducto(@PathParam("id") int id){
        AnimalEntity animalE = animal.getanimalById(id);
        if(animalE == null){
            throw new RuntimeException("El animal con id "+id+" no existe");
        }
        animal.deleteAnimal(id);
    }
}
