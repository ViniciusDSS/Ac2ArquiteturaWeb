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
import com.example.att4.dtos.CursosDTO;
import com.example.att4.dtos.DadosCursoDTO;
import com.example.att4.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

      @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long salvarCurso(@RequestBody CursosDTO cursosDTO){
        return cursoService.salvar(cursosDTO).getId();
    }

      @GetMapping
    public List<CursosDTO> listarCursos(){
        return cursoService.obterTodos();
    }

    @GetMapping("{id}")
    public DadosCursoDTO getById(@PathVariable Long id){
        return cursoService.obterCursoPorId(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        cursoService.remover(id);
    }

    @PutMapping("{id}")
    public void editar(@PathVariable Long id, @RequestBody CursosDTO dto){
        cursoService.editar(id, dto);
    }
}
    

