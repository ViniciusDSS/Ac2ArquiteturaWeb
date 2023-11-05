package com.example.att4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.att4.models.Cursos;


public interface CursoRepository {
 
    @Query("SELECT cs FROM Cursos cs LEFT JOIN FETCH cs.professores WHERE cs.id = :id")
    Optional<Cursos> findCursosFetchProfessores(@Param("id") Long id);

	Optional<Cursos> findById(Long curso_id);

 
}
