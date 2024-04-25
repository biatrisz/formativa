package com.avaliacaodois.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaodois.entities.Turma;
import com.avaliacaodois.repository.TurmaRepository;


@Service
public class TurmaService {
	private final TurmaRepository turmaRepository;
	
	@Autowired
	public TurmaService (TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
		
	}	
	public List<Turma> getAllturmaPorNome(String nome) {
        return turmaRepository.findByNome(nome);
    }
	public List<Turma> getAllturmaPorNomeAndDescricao(String nome, double descricao) {
        return turmaRepository.findByNomeAndDescricao(nome,descricao);
    }
	public List<Turma> getAllturmaPorDescricao(String descricao) {
        return turmaRepository.findByDescricao(descricao, 0);
    }

		public List<Turma> getAllturma() {
	        return turmaRepository.findAll();
	    }

	    public Turma getturmaById(Long id) {
	        Optional<Turma> turma = turmaRepository.findById(id);
	        return turma.orElse(null);
	    }

	    public Turma salvarturma(Turma turma) {
	        return turmaRepository.save(turma);
	    }

	    public Turma updateturma(Long id, Turma updatedturma) {
	        Optional<Turma> existingturma = turmaRepository.findById(id);
	        if (existingturma.isPresent()) {
	            updatedturma.setId(id);
	            return turmaRepository.save(updatedturma);
	        }
	        return null;
	    }
	    public boolean deleteturma(Long id) {
	        Optional<Turma> existingturma = turmaRepository.findById(id);
	        if (existingturma.isPresent()) {
	        	turmaRepository.deleteById(id);
	           return true;
	        }
	        return false;
		
	}

}
