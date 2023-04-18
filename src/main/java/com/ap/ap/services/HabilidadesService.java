package com.ap.ap.services;

import com.ap.ap.models.Habilidades;
import com.ap.ap.repository.HabilidadesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class HabilidadesService {
    @Autowired
    HabilidadesRepo habilidadesRepo;

    public List<Habilidades> list(){
        return habilidadesRepo.findAll();
    }
    public Optional<Habilidades> getOne(int id){
        return habilidadesRepo.findById(id);
    }

    public Habilidades save(Habilidades habilidades) {
        habilidadesRepo.save(habilidades);
        return habilidades;
    }
    public void delete(int id){
        habilidadesRepo.deleteById(id);
    }

    }

