package com.ap.ap.repository;

import com.ap.ap.models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ExperienciaRepo extends JpaRepository<Experiencia, Long> {
    public Optional<Experiencia> findById(Long idExp);

    public void deleteById(Long idExp);
    public Optional<Experiencia> findByTituloExp (String tituloExp);

}
