package com.avaliacaodois.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.avaliacaodois.entities.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {
	List <Aluno> findByCidade (String cidade);
	List <Aluno> findByRenda (double renda);
	List<Aluno> findByNomeCompleto(String nomeCompleto);
	List <Aluno> findByRa (String ra);
	List <Aluno> findByCidadeAndRenda (String cidade, double renda);
	//Buscar todos os alunos com nome "xxx"
	@Query ("SELECT a FROM Aluno a WHERE a.nome =: nome")
	List<Aluno> findByNome (@Param ("nome") String nome);
	
	@Query("SELECT a FROM a JOIN a.turma WHERE t.id = :turma")
	List<Aluno> findByTurmaId(@Param("turmaId") Long turmaId);

	@Query("SELECT a FROM Aluno a WHERE a.nomeCompleto LIKE :nomeCompleto")
	List<Aluno> findByNomeLike(@Param("NomeCompleto") String nomeCompleto);

	
	
	
	


}
