package com.ap.ap.services;

import com.ap.ap.exception.UserNotFoundException;
import com.ap.ap.models.Educacion;
import com.ap.ap.models.Usuario;
import com.ap.ap.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    public final UsuarioRepo usuarioRepo;

    @Autowired
    @Lazy
    public UsuarioService(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }
    public List<Usuario> list(){
        return usuarioRepo.findAll();
    }
    public Usuario editarUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }
    public void borrarUsuario(Long id){
        usuarioRepo.deleteById(id);
    }
    public Optional<Usuario> buscarUsuarioPorId(Long id){
        return usuarioRepo.findById(id);
    }
}
