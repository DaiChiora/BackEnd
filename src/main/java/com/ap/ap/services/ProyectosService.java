package com.ap.ap.services;


import com.ap.ap.models.Proyectos;
import com.ap.ap.repository.ProyectosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProyectosService {
    @Autowired
    ProyectosRepo proyectosRepo;

    public List<Proyectos> list(){
        return proyectosRepo.findAll();
    }
    public Optional<Proyectos> getOne(int id){
        return proyectosRepo.findById(id);
    }

    public Proyectos save(Proyectos proyectos) {
        proyectosRepo.save(proyectos);
        return proyectos;
    }
    public void delete(int id){ proyectosRepo.deleteById(id);
    }

}
