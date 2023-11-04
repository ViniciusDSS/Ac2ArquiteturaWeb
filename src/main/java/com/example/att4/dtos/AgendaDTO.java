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
public class AgendaDTO {

    private Long id;
    private String cursoOferecido;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String horaInicio;
    private String horaFim;
    private String profResponsavel;
    private String nomeCidade;
    private String estado;
    private String cep;

    private Long professores_id;
    private Long cursos_id;

    public Long getCursos_id() {
        return cursos_id;
    }
}
