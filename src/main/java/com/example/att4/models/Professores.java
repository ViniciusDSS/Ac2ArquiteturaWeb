package com.example.att4.models;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @OneToMany(mappedBy = "professoresCurso")
    private List<Cursos> cursos;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;
    private boolean especializacao;
    @OneToMany(mappedBy = "professoresAgenda")
    private List<Agenda> agenda;
    
    @Override
    public String toString() {
        return "ProfessoresCurso [id=" + id + ", nome=" + nome + "]";   
    }
    
    
}
