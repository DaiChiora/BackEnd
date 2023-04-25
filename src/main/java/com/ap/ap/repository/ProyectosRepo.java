package com.ap.ap.repository;

import com.ap.ap.models.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProyectosRepo extends JpaRepository<Proyectos, Integer> {
}
