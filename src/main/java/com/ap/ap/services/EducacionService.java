package com.ap.ap.services;


import com.ap.ap.models.Educacion;
import com.ap.ap.models.Experiencia;
import com.ap.ap.repository.EducacionRepo;
import com.ap.ap.repository.ExperienciaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EducacionService {
    private final EducacionRepo educacionRepo;

    @Autowired
    @Lazy
    public EducacionService(EducacionRepo educacionRepo) {
        this.educacionRepo = educacionRepo;
    }
    public Educacion addEducacion(Educacion educacion) {
       return educacionRepo.save(educacion);
    }
    public List<Educacion> buscarEducacion(){
       return educacionRepo.findAll();
    }
    public Educacion editarEducacion(Educacion educacion) {
       return educacionRepo.save(educacion);
    }
    public void borrarEducacion(Long idEdu){
       educacionRepo.deleteById(idEdu);
    }

    public Optional<Educacion> getOne (Long idEdu){
       return educacionRepo.findById(idEdu);
    }

    public Optional<Educacion> getByTituloEdu (String tituloEdu) {
       return educacionRepo.findByTituloEdu(tituloEdu);
    }

}
