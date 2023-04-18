package com.ap.ap.controller;


import antlr.StringUtils;
import com.ap.ap.Dto.dtoExperiencia;
import com.ap.ap.Security.Controller.Mensaje;
import com.ap.ap.models.Experiencia;
import com.ap.ap.services.ExperienciaService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins ="*")

public class ExperienciaController {
    @Autowired
    @Lazy
    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }
    @GetMapping("/all")
    public ResponseEntity<List <Experiencia>> obtenerExperiencia(){
        List <Experiencia> experiencias = experienciaService.buscarExperiencia();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Experiencia> editarExperiencia(@PathVariable("id") Long id, @RequestBody dtoExperiencia dtoExpe) {
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setTituloExp(dtoExpe.getTituloExp());
        experiencia.setFechaExp(dtoExpe.getFechaExp());
        experiencia.setDescExp(dtoExpe.getDescExp());
        experiencia.setImgExp(dtoExpe.getImgExp());
        experienciaService.editarExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("La experiencia se modificó correctamente"), HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id){
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Experiencia> crearExperiencia (@RequestBody Experiencia experiencia) {
        Experiencia nuevaExperiencia=experienciaService.addExperiencia(experiencia);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarExperiencia (@PathVariable("id")Long id){
        experienciaService.borrarExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
