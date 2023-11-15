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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Agenda {

    public Agenda(String cursoOferecido, LocalDate dataInicio, LocalDate dataFinal, String horaInicio, String horaFim,
            String profResponsavel, String nomeCidade, String estado, String cep) {
        this.cursoOferecido = cursoOferecido;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.profResponsavel = profResponsavel;
        this.nomeCidade = nomeCidade;
        this.estado = estado;
        this.cep = cep;
    }

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
