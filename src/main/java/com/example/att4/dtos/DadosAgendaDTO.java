package com.example.att4.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosAgendaDTO {
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String horaInicio;
    private String horaFim;
    private String nomeCidade;
    private String estado;
    private String cep;

    private ProfessoresDTO professores;
    private CursosDTO cursos;
}
