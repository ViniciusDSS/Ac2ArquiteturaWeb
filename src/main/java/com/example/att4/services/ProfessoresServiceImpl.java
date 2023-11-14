package com.example.att4.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.att4.dtos.DadosProfessoresDTO;
import com.example.att4.dtos.ProfessoresDTO;
import com.example.att4.exceptions.RegraNegocios;
import com.example.att4.models.Professores;
import com.example.att4.repository.AgendaRepository;
import com.example.att4.repository.ProfessoresRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessoresServiceImpl implements ProfessoresService {

     private final ProfessoresRepository professoresRepository;
     private final AgendaRepository agendaRepository;

    @Override
    public Professores salvar(ProfessoresDTO professoresDTO) {
        Professores p = new Professores();
        p.setNome(professoresDTO.getNome());
        p.setCpf(professoresDTO.getCpf());
        p.setRg(professoresDTO.getRg());
        p.setEndereco(professoresDTO.getEndereco());
        p.setCelular(professoresDTO.getCelular());

        return professoresRepository.save(p);
    }

    @Override
    public DadosProfessoresDTO obterProfessorPorId(Long id) {
       return professoresRepository.findById(id).map(
            (Professores p) -> {
                return DadosProfessoresDTO.builder()
                .id(p.getId())
                .nome(p.getNome())
                .cpf(p.getCpf())
                .rg(p.getRg())
                .endereco(p.getEndereco())
                .celular(p.getCelular())
                .build();
            }
        ).orElseThrow(
            () -> new RegraNegocios("Professor não encontrado.")
        );
    }

    @Override
    public void remover(Long id) {
        Professores professores = professoresRepository.findById(id).orElseThrow(
            () -> new RegraNegocios("Professor não encontrado")
        );

        if(agendaRepository.existsByProfessoresId(professores.getId())){
            throw new RegraNegocios("Professor não pode ser excluido, verifique a Agenda.");
        }

        professoresRepository.deleteById(id);
    }

    @Override
    public void editar(Long id, ProfessoresDTO professoresDTO) {
        Professores professores = professoresRepository.findById(id).orElseThrow(
            () -> new RegraNegocios("Professor não encontrado!")
        );

        professores.setNome(professoresDTO.getNome());
        professores.setCpf(professoresDTO.getCpf());
        professores.setRg(professoresDTO.getRg());
        professores.setEndereco(professoresDTO.getEndereco());
        professores.setCelular(professoresDTO.getCelular());

        professoresRepository.save(professores);
    }

    @Override
    public List<ProfessoresDTO> obterTodos() {
          List<ProfessoresDTO> prof = professoresRepository.findAll().stream().map(
            (Professores p) -> {
                return ProfessoresDTO.builder()
                .id(p.getId())
                .nome(p.getNome())
                .cpf(p.getCpf())
                .rg(p.getRg())
                .endereco(p.getEndereco())
                .celular(p.getCelular())
                .build();
            }
        ).collect(Collectors.toList());

        return prof;
    }
    
}
