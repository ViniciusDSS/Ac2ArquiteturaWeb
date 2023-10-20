package com.example.att4.services;

import java.util.List;

import com.example.att4.dtos.CursosDTO;
import com.example.att4.dtos.DadosCursoDTO;
import com.example.att4.models.Cursos;

public interface CursoService {

    Cursos salvar(CursosDTO cursosDTO);
DadosCursoDTO obterCursoPorId(Long id);
void remover(Long id);
void editar(Long id, CursosDTO cursoDto);
List<DadosCursoDTO> obterTodos();
    
}
