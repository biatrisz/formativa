package com.avaliacaodois.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avaliacaodois.entities.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {
 List <Aluno> findByCidade (String cidade);
 List <Aluno> findByRenda (double renda);
 Aluno findByRa (String ra);
 List <Aluno> findByCidadeAndRenda (String cidade, double renda);
 //Buscar todos os alunos com nome "xxx"
 @Query ("SELECT a FROM Aluno a WHERE a.nome =: nome")
 List<Aluno> findByNome (@Param ("nome") String nome);
 
}
