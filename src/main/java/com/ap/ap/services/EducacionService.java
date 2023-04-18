package com.ap.ap.services;

import com.ap.ap.models.Educacion;
import com.ap.ap.repository.EducacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class EducacionService {
    @Autowired
    private final EducacionRepo educacionRepo;


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
    public void borrarEducacion(Long id){
        educacionRepo.deleteById(id);
    }
    public Optional<Educacion> getOne (Long idEdu){
        return educacionRepo.findById(idEdu);
    }

    public Optional<Educacion> getByTituloEdu (String tituloEdu) {
        return educacionRepo.findByTituloEdu(tituloEdu);
    }


}
