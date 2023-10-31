package com.example.att4.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.att4.models.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
    
     @Query("SELECT ag FROM Agenda ag LEFT JOIN FETCH ag.professores WHERE ag.id = :id")
    Agenda findAgendaFetchProfessores(@Param("id") Integer id);

    @Query("SELECT ag FROM Agenda ag LEFT JOIN FETCH ag.professores WHERE ag.dataInicio = :dataInicio")
    Agenda findByDataFinal(@Param("dataInicio") Date dataInicio);

    boolean existsByProfessoresId(Long id);

    boolean existsByCursosId(Long id);
}
