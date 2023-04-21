package com.ap.ap.controller;

import com.ap.ap.Dto.dtoExperiencia;
import com.ap.ap.Dto.dtoHabilidades;
import com.ap.ap.Security.Controller.Mensaje;
import com.ap.ap.models.Experiencia;
import com.ap.ap.models.Habilidades;
import com.ap.ap.services.ExperienciaService;
import com.ap.ap.services.HabilidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadesController {
    @Autowired

    HabilidadesService habilidadesService;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list(){
        List <Habilidades> list = habilidadesService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        Habilidades habilidades = habilidadesService.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id")int id){
        habilidadesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Habilidades> create (@RequestBody Habilidades habilidades) {
        Habilidades nuevaHabilidades=habilidadesService.save(habilidades);
        return new ResponseEntity<>(nuevaHabilidades, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidades dtohabilidades) {
        Habilidades habilidades = habilidadesService.getOne(id).get();
        habilidades.setNombreHabilidad(dtohabilidades.getNombreHabilidad());
        habilidades.setPorcentaje(dtohabilidades.getPorcentaje());
        habilidadesService.save(habilidades);
        return new ResponseEntity(new Mensaje("La habilidad se modificó correctamente"), HttpStatus.OK);
    }








}
