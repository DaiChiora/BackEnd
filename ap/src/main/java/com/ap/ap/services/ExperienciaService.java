package com.ap.ap.services;

import com.ap.ap.models.Experiencia;
import com.ap.ap.repository.ExperienciaRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ExperienciaService {
    private final ExperienciaRepo experienciaRepo;

   @Autowired
    public ExperienciaService(ExperienciaRepo experienciaRepo) {
        this.experienciaRepo = experienciaRepo;
    }
    public Experiencia addExperiencia(Experiencia experiencia) {
       return experienciaRepo.save(experiencia);
    }
    public List<Experiencia> buscarExperiencia(){
       return experienciaRepo.findAll();
    }
    public Experiencia editarExperiencia(Experiencia experiencia) {
       return experienciaRepo.save(experiencia);
    }
    public void borrarExperiencia(Long idExp){
       experienciaRepo.deleteById(idExp);
    }

    public Optional<Experiencia> getOne (Long idExp){
       return experienciaRepo.findById(idExp);
    }
    //public boolean existsById (Long id){
      // return experienciaRepo.existsById(id);
    //}
    public Optional<Experiencia> getByTituloExp (String tituloExp) {
       return experienciaRepo.findByTituloExp(tituloExp);
    }
    //public boolean existsByTituloExp (String tituloExp){
      // return experienciaRepo.existByTituloExp(tituloExp);
    //}
}
