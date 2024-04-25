package com.avaliacaodois.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaodois.entities.Aluno;
import com.avaliacaodois.repository.AlunoRepository;


@Service

public class AlunoService {
	private final AlunoRepository alunoRepository;
	@Autowired
	public AlunoService (AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	public List<Aluno> getAllalunoPorCidade(String cidade) {
		return alunoRepository.findByCidade(cidade);
	}

	public List<Aluno> getAllalunoPorRenda(Double renda) {
		return alunoRepository.findByRenda(renda);
	}
	public Aluno getAllalunoPorRA(String ra) {
		return alunoRepository.findByRa(ra);
	}
	public List<Aluno> getAllalunoPorCidadeAndRenda(String cidade, Double renda) {
		return alunoRepository.findByCidadeAndRenda(cidade, renda);
	}

	public Aluno getalunoById(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElse(null);
	}

	public Aluno salvaraluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno updatealuno(Long id, Aluno updatedaluno) {
		Optional<Aluno> existingaluno = alunoRepository.findById(id);
		if (existingaluno.isPresent()) {
			updatedaluno.setId(id);
			return alunoRepository.save(updatedaluno);
		}
		return null;
	}
	public boolean deletealuno(Long id) {
		Optional<Aluno> existingaluno = alunoRepository.findById(id);
		if (existingaluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;

	}
	//@query
	public List <Aluno> findByNome (String nome){
		return alunoRepository.findByNome(nome);
	}

}
