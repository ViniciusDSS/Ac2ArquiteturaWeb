package com.example.att4.services;

import java.util.List;

import com.example.att4.dtos.AgendaDTO;
import com.example.att4.dtos.CursosDTO;
import com.example.att4.dtos.DadosCursoDTO;
import com.example.att4.models.Agenda;
import com.example.att4.models.Cursos;

public interface AgendaService {
    Agenda salvar(AgendaDTO AgendaDTO);
    AgendaDTO obterAgendaPorId(Long id);
    void remover(Long id);
    void editar(Long id, AgendaDTO agendaDto);
    List<DadosCursoDTO> obterTodos();
}
