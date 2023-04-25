package com.ap.ap.controller;


import com.ap.ap.Dto.dtoProyectos;
import com.ap.ap.Security.Controller.Mensaje;
import com.ap.ap.models.Proyectos;
import com.ap.ap.services.ProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectosController {
    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/all")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        proyectosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Proyectos> create(@RequestBody Proyectos proyectos) {
        Proyectos nuevoProyecto = proyectosService.save(proyectos);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos) {
        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombre(dtoproyectos.getNombre());
        proyectos.setDescripcion(dtoproyectos.getDescripcion());
        proyectos.setLink(dtoproyectos.getLink());
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("El proyecto se modificó correctamente"), HttpStatus.OK);
    }
}
