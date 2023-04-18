package com.ap.ap.repository;

import com.ap.ap.models.Educacion;
import com.ap.ap.models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Long> {
    public Optional<Educacion> findById(Long idEdu);

    public void deleteById(Long idEdu);
    public Optional<Educacion> findByTituloEdu (String tituloEdu);

}
