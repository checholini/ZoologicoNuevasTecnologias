/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.konrad.zoologico.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author SergioRodriguez
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addResourseClasses(resources);
        return resources;
    }
    
    public void addResourseClasses(Set<Class<?>> resources){
        resources.add(co.edu.konrad.zoologico.resources.AlimentacionResource.class);
        resources.add(co.edu.konrad.zoologico.resources.FechaHoraResource.class);
        resources.add(co.edu.konrad.zoologico.resources.ShowResource.class);
        resources.add(co.edu.konrad.zoologico.resources.RatingShowResource.class);
        resources.add(co.edu.konrad.zoologico.resources.RatingAnimalResource.class);
        resources.add(co.edu.konrad.zoologico.resources.LugarResource.class);
        resources.add(co.edu.konrad.zoologico.resources.ZooResource.class);
        resources.add(co.edu.konrad.zoologico.resources.AnimalResource.class);
        resources.add(co.edu.konrad.zoologico.resources.TipoAnimalResource.class);
        resources.add(co.edu.konrad.zoologico.resources.CuidadorResource.class);
        resources.add(co.edu.konrad.zoologico.resources.DocumentoResource.class);
        resources.add(co.edu.konrad.zoologico.resources.EncargadoResource.class);
        resources.add(co.edu.konrad.zoologico.resources.CuidadorResource.class);
        resources.add(co.edu.konrad.zoologico.resources.ParticipantesResource.class);
        resources.add(co.edu.konrad.zoologico.resources.TipoDeDocumentoResource.class);
    }
}
