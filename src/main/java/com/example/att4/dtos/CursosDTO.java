package com.example.att4.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CursosDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String objetivos;
    private String ementa;
    private int cargaHoraria;
    private ProfessoresDTO professores;
    
}
