package com.example.att4.services;

import java.util.List;

import com.example.att4.dtos.ProfessoresDTO;
import com.example.att4.models.Professores;

public interface ProfessoresService {
    
    Professores salvar(ProfessoresDTO professoresDTO);
    ProfessoresDTO obterProfessorPorId(Long id);
    void remover(Long id);
    void editar(Long id, ProfessoresDTO professoresDTO);
    List<ProfessoresDTO> obterTodos();
}
