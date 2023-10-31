package com.example.att4.models;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cursoOferecido;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataFinal;
    private String horaInicio;
    private String horaFim;
    private String profResponsavel;
    private String nomeCidade;
    private String estado;
    private String cep;

    @ManyToOne
    @JoinColumn(name ="professores_id")
    private Professores professores;

    public Professores getProfessores() {
        return professores;
    }
    
    public void setProfessores(Professores professores) {
        this.professores = professores;
    }

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Cursos cursos;

    public Cursos getCursos() {
        return cursos;
    }
    
    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    
}
