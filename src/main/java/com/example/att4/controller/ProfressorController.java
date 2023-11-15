package com.example.att4.controller;

import java.util.List;

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

import com.example.att4.dtos.DadosProfessoresDTO;
import com.example.att4.dtos.ProfessoresDTO;
import com.example.att4.services.ProfessoresService;


@RestController
@RequestMapping("/professores")
public class ProfressorController {

     private ProfessoresService professoresService;

    public ProfressorController(ProfessoresService professoresService){
        this.professoresService = professoresService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long insert(@RequestBody ProfessoresDTO professoresDTO) {
        return professoresService.salvar(professoresDTO).getId();
    }

    @GetMapping
    public List<ProfessoresDTO> listarTodos(){
        return professoresService.obterTodos();
    }

    @GetMapping("{id}")
    public DadosProfessoresDTO getById(@PathVariable Long id){
        return professoresService.obterProfessorPorId(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        professoresService.remover(id);
    }

    @PutMapping("{id}")
    public void editar(@PathVariable Long id, @RequestBody ProfessoresDTO dto){
        professoresService.editar(id, dto);
    }
    
    
}
