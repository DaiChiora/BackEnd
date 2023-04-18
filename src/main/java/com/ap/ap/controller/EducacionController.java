package com.ap.ap.controller;


import com.ap.ap.Dto.dtoEducacion;
import com.ap.ap.Dto.dtoExperiencia;
import com.ap.ap.Security.Controller.Mensaje;
import com.ap.ap.models.Educacion;
import com.ap.ap.models.Experiencia;
import com.ap.ap.services.EducacionService;
import com.ap.ap.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/educacion")
@CrossOrigin (origins ="*")

public class EducacionController {
    @Autowired
    @Lazy
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }
    @GetMapping("/all")
    public ResponseEntity<List <Educacion>> obtenerEducacion(){
        List <Educacion> educaciones = educacionService.buscarEducacion();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Educacion> editarEducacion(@PathVariable("id") Long id, @RequestBody dtoEducacion dtoEdu) {
        Educacion educacion = educacionService.getOne(id).get();
        educacion.setTituloEdu(dtoEdu.getTituloEdu());
        educacion.setFechaEdu(dtoEdu.getFechaEdu());
        educacion.setDescEdu(dtoEdu.getDescEdu());
        educacion.setImgEdu(dtoEdu.getImgEdu());
        educacionService.editarEducacion(educacion);
        return new ResponseEntity(new Mensaje("La educacion se modificó correctamente"), HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Educacion> crearEducacion (@RequestBody Educacion educacion) {
        Educacion nuevaEducacion=educacionService.addEducacion(educacion);
        return new ResponseEntity<>(nuevaEducacion, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarEducacion (@PathVariable("id")Long id){
        educacionService.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
