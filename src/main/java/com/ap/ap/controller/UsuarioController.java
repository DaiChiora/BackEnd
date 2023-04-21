package com.ap.ap.controller;


import com.ap.ap.Dto.dtoUsuario;
import com.ap.ap.Security.Controller.Mensaje;
import com.ap.ap.models.Usuario;
import com.ap.ap.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "**")
public class UsuarioController {
    @Autowired
    @Lazy
    UsuarioService usuarioService;



    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> list(){
        List <Usuario> list = usuarioService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable("id") Long id, @RequestBody dtoUsuario dtous) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id).get();
        usuario.setNombre(dtous.getNombre());
        usuario.setApellido(dtous.getApellido());
        usuario.setDescripcion(dtous.getDescripcion());
        usuario.setImg(dtous.getImg());
        usuarioService.editarUsuario(usuario);
        return new ResponseEntity(new Mensaje("El usuario se modificó correctamente"), HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.buscarUsuarioPorId(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Usuario> crearUsuario (@RequestBody Usuario usuario) {
        Usuario nuevoUsuario=usuarioService.addUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarUsuario (@PathVariable("id")Long id){
        usuarioService.borrarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
