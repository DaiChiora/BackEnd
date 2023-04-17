package com.ap.ap.repository;


import com.ap.ap.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre (String nombre);
}
