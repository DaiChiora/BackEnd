package com.ap.ap.repository;

import com.ap.ap.models.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HabilidadesRepo extends JpaRepository<Habilidades, Integer> {


}
