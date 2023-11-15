package com.example.att4.att4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.att4.models.Agenda;
import com.example.att4.models.Cursos;
import com.example.att4.models.Professores;
import com.example.att4.repository.AgendaRepository;
import com.example.att4.repository.CursoRepository;
import com.example.att4.repository.ProfessoresRepository;

@SpringBootApplication
public class Att4Application {

	
	@Bean
	public CommandLineRunner init(
		@Autowired AgendaRepository agendaRepository,
		@Autowired CursoRepository cursoRepository,
		@Autowired ProfessoresRepository professoresRepository
	){
		return args ->{
			System.out.println("Cadastrar Professor");
			Professores p1 = new Professores("Gabriel","444555777","78878744","São Paulo","11 988547222",true);
			Professores p2 = new Professores("Claudia","300224577","545454522","Rio de Janeiro","18 989895654", true);
			Professores p3 = new Professores("Franses","265984771","47125684","Acre","87 547855555",false);

			p1 = professoresRepository.save(p1);
			p2 = professoresRepository.save(p2);
			p3 = professoresRepository.save(p3);
			
			List<Professores> listaProfessores = professoresRepository.findAll();

			System.out.println("Cadastrar Curso");
			Cursos c1 = new Cursos("Desenvolviento De Sistemas","Este curso oferece uma abordagem abrangente para formar profissionais capazes de analisar, projetar e desenvolver sistemas de informação.","O principal objetivo deste curso é formar profissionais aptos a atuar no desenvolvimento de sistemas eficientes e inovadores.","A ementa deste curso abrange tópicos essenciais, como programação, banco de dados, engenharia de software, análise de sistemas e gestão de projetos.",26298);
			Cursos c2 = new Cursos("Banco de Dados","Este curso oferece uma compreensão aprofundada dos princípios fundamentais de gerenciamento de banco de dados.","O curso tem como objetivo formar profissionais capacitados a projetar, implementar e administrar sistemas de banco de dados robustos e eficientes. ","A ementa abrange temas essenciais, incluindo modelagem entidade-relacionamento, projeto de banco de dados, SQL avançado, procedimentos armazenados, triggers, administração de sistemas de gerenciamento de banco de dados (SGBD) e estratégias de backup e recuperação. ",21915);
			Cursos c3 = new Cursos("Rede de Computadoes","Este curso proporciona uma compreensão abrangente dos princípios e tecnologias que sustentam as redes de computadores.","O objetivo principal deste curso é formar profissionais capazes de projetar, implementar e gerenciar redes de computadores eficientes e seguras.","A ementa abrange tópicos cruciais, como topologias de rede, protocolos de comunicação, roteamento, segurança de redes, virtualização, administração de redes e solução de problemas. ",35064);
			
			
			c1 = cursoRepository.save(c1);
			c2 = cursoRepository.save(c2);
			c3 = cursoRepository.save(c3);

			Optional<Cursos> listaCursos = cursoRepository.findAll();

			System.out.println("Cadastrar Agenda");
			Agenda ag1 = new Agenda(c1.getNome(),LocalDate.now(),LocalDate.now(),"07:00","13:00",p1.getNome(),"Votorantim","SP","184755");
			Agenda ag2 = new Agenda(c2.getNome(),LocalDate.now(),LocalDate.now(),"07:30","13:00",p2.getNome(),"Ribeirão Preto","SP","1955548");
			Agenda ag3 = new Agenda(c3.getNome(),LocalDate.now(),LocalDate.now(),"19:00","22:00",p3.getNome(),"Sorocaba","SP","1898852");
			
			ag1 = agendaRepository.save(ag1);
			ag2 = agendaRepository.save(ag2);
			ag3 = agendaRepository.save(ag3);
			

			List<Agenda> listaAgendas = agendaRepository.findAll();
			listaAgendas.forEach(System.out::println);
		};
	}

    public static void main(String[] args) {
		SpringApplication.run(Att4Application.class, args);
	}
    
}
