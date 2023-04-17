package com.ap.ap.controller;

import com.ap.ap.Dto.dtoEducacion;
import com.ap.ap.Security.Controller.Mensaje;
import com.ap.ap.models.Educacion;
import com.ap.ap.models.Experiencia;
import com.ap.ap.services.EducacionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/educacion")
public class EducacionController {
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
        return new ResponseEntity(new Mensaje("La educación se modificó correctamente"), HttpStatus.OK);
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
