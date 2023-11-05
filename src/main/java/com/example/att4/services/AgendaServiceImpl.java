package com.example.att4.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.att4.dtos.AgendaDTO;
import com.example.att4.dtos.DadosAgendaDTO;
import com.example.att4.dtos.ProfessoresDTO;
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
       a.setNomeCidade(agendaDTO.getNomeCidade());
       a.setEstado(agendaDTO.getEstado());
       a.setCep(agendaDTO.getCep()); 
        a.setDataInicio(a.getDataInicio() != null ? a.getDataInicio() : LocalDate.now());
        a.setDataFinal(a.getDataFinal() != null ? a.getDataFinal() : LocalDate.now());

            return agendaRepository.save(a);
    }

    @Override
    public DadosAgendaDTO obterAgendaPorId(Long id) {
        return agendaRepository.findById(id).map(
            (Agenda a ) -> {
                return DadosAgendaDTO.builder()
                .id(a.getId())
                .professores(a.getProfessores() != null ? ProfessoresDTO.builder()
                .id(a.getProfessores().getId())
                .nome(a.getProfessores().getNome())
                .cpf(a.getProfessores().getCpf())
                .rg(a.getProfessores().getRg())
                .endereco(a.getProfessores().getEndereco())
                .celular(a.getProfessores().getCelular())
                .build() : null)

                .dataInicio(a.getDataInicio())
                .dataFinal(a.getDataFinal())
                .horaInicio(a.getHoraInicio())
                .horaFim(a.getHoraFim())
                .nomeCidade(a.getNomeCidade())
                .estado(a.getEstado())
                .cep(a.getCep())
                .build();
            }
        ).orElseThrow(
            () -> new RegraNegocios("Agenda não encontrada")
        );
    }

    @Override
    public void remover(Long id) {
        Agenda agenda = agendaRepository.findById(id).orElseThrow(
            () -> new RegraNegocios("Agenda não encontrada")
        );
        agendaRepository.deleteById(agenda.getId());
    }

    @Override
    public void editar(Long id, AgendaDTO agendaDto) {
      Cursos cursos = cursoRepository.findById(agendaDto.getCursos_id()).orElseThrow(
        () -> new RegraNegocios("O curso não foi encontrado")
      );

      Professores professores = professoresRepository.findById(agendaDto.getProfessores_id()).orElseThrow(
        () -> new RegraNegocios("O professor não foi encontrado")
      );
      Agenda agenda = agendaRepository.findById(id).orElseThrow(
        () -> new RegraNegocios("Esta Agenda não foi encotrada")
      );

      agenda.setCursos(cursos);
      agenda.setProfessores(professores);
      agenda.setDataInicio(agendaDto.getDataInicio() != null ? agendaDto.getDataInicio() : LocalDate.now());
      agenda.setDataFinal(agendaDto.getDataFinal() != null ? agendaDto.getDataFinal() : LocalDate.now());
      agenda.setHoraInicio(agendaDto.getHoraInicio());
      agenda.setHoraFim(agendaDto.getHoraFim());
      agenda.setNomeCidade(agendaDto.getNomeCidade());
      agenda.setEstado(agendaDto.getEstado());
      agenda.setCep(agendaDto.getCep());

      agendaRepository.save(agenda);
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
