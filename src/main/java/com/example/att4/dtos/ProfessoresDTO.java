package com.example.att4.dtos;

import java.util.List;

import com.example.att4.models.Cursos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessoresDTO {
    private Long id;
    private String nome;
    private List<Cursos> cursos;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;
    private boolean especializacao;
}
