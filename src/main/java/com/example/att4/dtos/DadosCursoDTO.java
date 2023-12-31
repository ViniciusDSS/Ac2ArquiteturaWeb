package com.example.att4.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosCursoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String objetivos;
    private String ementa;
    private int cargaHoraria;
    private List<ProfessoresDTO> professores;
    
}
