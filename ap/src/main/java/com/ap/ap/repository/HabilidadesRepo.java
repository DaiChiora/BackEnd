package com.ap.ap.repository;

import com.ap.ap.models.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HabilidadesRepo extends JpaRepository<Habilidades, Integer> {
    Optional<Habilidades> findByNombreHabilidad (String nombreHabilidad);

}
