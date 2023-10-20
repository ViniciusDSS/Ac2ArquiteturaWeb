package com.example.att4.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDTO {

    private Long id;
    private String cursoOferecido;
    private int dataInicio;
    private int dataFim;
    private String horaInicio;
    private String horaFim;
    private String profResponsavel;
    private String nomeCidade;
    private String estado;
    private int cep;
}
