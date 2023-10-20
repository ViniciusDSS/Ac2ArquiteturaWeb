package com.example.att4.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cursos {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(length = 200, nullable = false)
private String nome;
@Column(nullable = false)
private String descricao;
private String objetivos;
private String ementa;
private int cargaHoraria;
@ManyToOne
private List<Agenda> agenda;
@JoinColumn(name = "agenda_id")
private Agenda agenda_id;
    
}
