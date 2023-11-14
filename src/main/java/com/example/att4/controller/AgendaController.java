package com.example.att4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.att4.dtos.AgendaDTO;
import com.example.att4.dtos.DadosAgendaDTO;
import com.example.att4.services.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private AgendaService agendaService;

    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }
    
     @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long salvarAgenda(@RequestBody AgendaDTO agendaDTO){
        return agendaService.salvar(agendaDTO).getId();
    }

    @GetMapping
    public List<AgendaDTO> listarAgenda() {
        return agendaService.obterTodos();
    }

      @GetMapping("{id}")
    public DadosAgendaDTO getById(@PathVariable Long id){
        return agendaService.obterAgendaPorId(id);
    }

     @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        agendaService.remover(id);
    }

     @PutMapping("{id}")
    public void editar(@PathVariable Long id, @RequestBody AgendaDTO dto){
        agendaService.editar(id, dto);
    }

}
