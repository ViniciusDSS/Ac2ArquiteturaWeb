package com.example.att4.models;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
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

    @OneToMany(mappedBy = "professores")
    private List<Agenda> agenda;

    public List<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agenda = agenda;
    }
  
     @ManyToMany(mappedBy = "professores")
     private List<Cursos> Cursos;

     public List<Cursos> getCursos() {
        return cursos;
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }
      
    
}
