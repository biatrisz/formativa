package com.avaliacaodois.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaodois.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	List<Turma> findByNome(String nome);
	List<Turma> findByDescricao(String nome, double descricao);
	List<Turma> findByNomeAndDescricao(String nome, double descricao);

}