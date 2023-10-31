package com.example.att4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.att4.models.Cursos;
import com.example.att4.models.Professores;

public interface ProfessoresRepository extends JpaRepository<Professores, Long>{
   
    @Query("SELECT cs FROM Cursos cs LEFT JOIN FETCH cs.professores WHERE cs.id = :id")
    Cursos findCursosFetchProfessores(@Param("id") Long id);
}
