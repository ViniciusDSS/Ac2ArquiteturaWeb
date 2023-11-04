package com.example.att4.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.att4.dtos.AgendaDTO;
import com.example.att4.exceptions.RegraNegocios;
import com.example.att4.models.Agenda;
import com.example.att4.models.Cursos;
import com.example.att4.models.Professores;
import com.example.att4.repository.AgendaRepository;
import com.example.att4.repository.CursoRepository;
import com.example.att4.repository.ProfessoresRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService {

    private final AgendaRepository agendaRepository;
    private final CursoRepository cursoRepository;
    private final ProfessoresRepository professoresRepository;
    

	@Override
    public Agenda salvar(AgendaDTO agendaDTO) {
        Cursos cursos = cursoRepository.findById(agendaDTO.getCursos_id()).orElseThrow(
        () -> new RegraNegocios("Curso não encontrado")
       );

       Professores professores = professoresRepository.findById(agendaDTO.getProfessores_id()).orElseThrow(
        () -> new RegraNegocios("Professor não encontrado")
       );

       Agenda a = new Agenda();
       a.setCursos(cursos);
       a.setProfessores(professores);
       a.setDataInicio(agendaDTO.getDataInicio());
       a.setDataFinal(agendaDTO.getDataFinal());
       a.setHoraInicio(agendaDTO.getHoraInicio());
       a.setHoraFim(agendaDTO.getHoraFim());


	return null;
    }

    @Override
    public AgendaDTO obterAgendaPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterAgendaPorId'");
    }

    @Override
    public void remover(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public void editar(Long id, AgendaDTO agendaDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }

    @Override
    public List<AgendaDTO> obterTodos() {
        List<AgendaDTO> agenda = agendaRepository.findAll().stream().map(
            (Agenda a) -> {
                return AgendaDTO.builder()
                .id(a.getId())
                .dataInicio(a.getDataInicio())
                .dataFinal(a.getDataFinal())
                .horaInicio(a.getHoraInicio())
                .horaFim(a.getHoraFim())
                .nomeCidade(a.getNomeCidade())
                .estado(a.getEstado())
                .cep(a.getCep())
                .professores_id(Long.valueOf(a.getProfessores().getId().toString()))
                .cursos_id(Long.valueOf(a.getCursos().getId().toString()))
                .build();
        }).collect(Collectors.toList());
		return agenda;
    }
}
