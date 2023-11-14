package com.example.att4.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.att4.dtos.CursosDTO;
import com.example.att4.dtos.DadosCursoDTO;
import com.example.att4.dtos.ProfessoresDTO;
import com.example.att4.exceptions.RegraNegocios;
import com.example.att4.models.Cursos;
import com.example.att4.models.Professores;
import com.example.att4.repository.AgendaRepository;
import com.example.att4.repository.CursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final AgendaRepository agendaRepository;

    @Override
    public Cursos salvar(CursosDTO cursosDTO) {
        Cursos c = new Cursos();
        c.setNome(cursosDTO.getNome());
        c.setCargaHoraria(cursosDTO.getCargaHoraria());
        c.setDescricao(cursosDTO.getDescricao());
        c.setEmenta(cursosDTO.getEmenta());
        c.setObjetivos(cursosDTO.getObjetivos());
        
        return cursoRepository.save(c);
        
    }
    @Override
    public DadosCursoDTO obterCursoPorId(Long id){
        return cursoRepository
      .findCursosFetchProfessores(id)
      .map((Cursos c) -> {
        return DadosCursoDTO
          .builder()
          .id(c.getId())
          .descricao(c.getDescricao())
          .cargaHoraria(c.getCargaHoraria())
          .objetivos(c.getObjetivos())
          .ementa(c.getEmenta())
          .professores(
            c.getProfessores() != null
              ? c
                .getProfessores()
                .stream()
                .map((Professores p) -> {
                  return ProfessoresDTO
                    .builder()
                    .id(p.getId())
                    .nome(p.getNome())
                    .cpf(p.getCpf())
                    .rg(p.getRg())
                    .endereco(p.getEndereco())
                    .celular(p.getCelular())
                    .build();
                })
                .collect(Collectors.toList())
              : null
          )
          .build();
      })
      .orElseThrow(() ->
        new RegraNegocios("Curso não encontrado")
      );
  }

       
    @Override
    public void remover(Long id) {
        Cursos cursos = cursoRepository
        .findById(id)
        .orElseThrow(() ->
          new RegraNegocios("Curso não encontrado.")
        );
  
      if (agendaRepository.existsByCursosId(cursos.getId())) {
        throw new RegraNegocios(
          "Curso em uso não pode ser excluido."
        );
      }
  
      cursoRepository.deleteById(id);
    }
    @Override
    public void editar(Long id, CursosDTO cursoDto) {
        Cursos cursos = cursoRepository
        .findById(id)
        .orElseThrow(() ->
          new RegraNegocios("Curso não encontrado.")
        );
  
      cursos.setDescricao(cursoDto.getDescricao());
      cursos.setCargaHoraria(cursoDto.getCargaHoraria());
      cursos.setObjetivos(cursoDto.getObjetivos());
      cursos.setEmenta(cursoDto.getEmenta());
      cursoRepository.save(cursos);
    }

    @Override
    public List<CursosDTO> obterTodos() {
        List<CursosDTO> cursos = cursoRepository
        .findAll()
        .stream()
        .map((Cursos c) -> {
          return CursosDTO
            .builder()
            .id(c.getId())
            .descricao(c.getDescricao())
            .cargaHoraria(c.getCargaHoraria())
            .objetivos(c.getObjetivos())
            .ementa(c.getEmenta())
            .build();
        })
        .collect(Collectors.toList());
  
      return cursos;
    }

}
