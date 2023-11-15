package com.example.att4.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cursos {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nome;
private String descricao;
private String objetivos;
private String ementa;
private int cargaHoraria;



@ManyToMany
    @JoinTable(
        name = "professores&cursos",
        joinColumns = @JoinColumn(name = "cursos_id"),
        inverseJoinColumns = @JoinColumn(name = "professores_id")
    )
    private List<Professores> professores;

    public List<Professores> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professores> professores) {
        this.professores = professores;
    }

     @OneToMany(mappedBy = "cursos")
    private List<Agenda> agenda;

    public Cursos(String nome, String descricao, String objetivos, String ementa, int cargaHoraria) {
        this.nome = nome;
        this.descricao = descricao;
        this.objetivos = objetivos;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
    }

    public List<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agenda = agenda;
    }

}
