package com.example.att4.services;

import java.util.List;

import com.example.att4.dtos.AgendaDTO;
import com.example.att4.dtos.DadosAgendaDTO;
import com.example.att4.models.Agenda;


public interface AgendaService {
    Agenda salvar(AgendaDTO AgendaDTO);
    DadosAgendaDTO obterAgendaPorId(Long id);
    void remover(Long id);
    void editar(Long id, AgendaDTO agendaDto);
    List<AgendaDTO> obterTodos();
}
