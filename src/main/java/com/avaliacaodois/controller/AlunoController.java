package com.avaliacaodois.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacaodois.entities.Aluno;
import com.avaliacaodois.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
private final AlunoService alunoService;

@Autowired
public AlunoController(AlunoService alunoService) {
this.alunoService = alunoService;
}

@GetMapping("/{id}")
public ResponseEntity<Aluno> getalunoById(@PathVariable Long id) {
Aluno aluno = alunoService.getalunoById(id);
if (aluno != null) {
return ResponseEntity.ok(aluno);
} else {
return ResponseEntity.notFound().build();
}
}

@GetMapping("/")
public ResponseEntity<List<Aluno>> getAllAluno() {
List<Aluno> aluno = alunoService.getAllAluno();
return ResponseEntity.ok(aluno);
}
//Query Method
@GetMapping("/cidade/{cidade}")
public ResponseEntity<List<Aluno>> buscarPorCidade(@PathVariable String cidade){
List<Aluno> alunos = alunoService.findByCidade (cidade);
return ResponseEntity.ok(alunos);
}
/*//Query Method
@GetMapping("/nome/{nome}")
public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable String nome){
List<Aluno> alunos = alunoService.buscarAlunosPorNome (nome);
return ResponseEntity.ok(alunos);
}*/
//Query Method
@GetMapping("/cidade/{cidade}/renda/{renda}")
public ResponseEntity<List<Aluno>> buscarCidadeAndRenda(@PathVariable String cidade, Double renda){
List<Aluno> alunos = alunoService.getAllalunoPorCidadeAndRenda (cidade, renda);
return ResponseEntity.ok(alunos);
}
//Query Method
@GetMapping("/ra/{ra}")
public ResponseEntity<List<Aluno>> getAllAlunosPorRa(@PathVariable 	String ra){
List<Aluno> alunos = alunoService.getAllalunoPorRA (ra);
return ResponseEntity.ok(alunos);
}
//@query
@GetMapping("/turma/{turmaId)")
public List<Aluno> findAlunosPorTurma(@PathVariable Long turmaId){
return alunoService.findByTurmaId(turmaId);
}
@Query
@GetMapping("/nome/{nome}")
public List<Aluno> findAlunoPorNome(@PathVariable String nome){
return alunoService.findByNome(nome);
}
//@query
@GetMapping("/nome-completo/{nomeCompleto}")
public  List<Aluno> findByNomeLike(@PathVariable String nomeCompleto){
return alunoService.findByNome(nomeCompleto);
}

@PostMapping("/")
public ResponseEntity<Aluno> criarAluno(@RequestBody @Valid Aluno aluno) {
Aluno criarAluno = alunoService.salvaraluno(aluno);
return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);
}


@PutMapping("/{id}")
public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
Aluno updatedAluno = alunoService.updatealuno(id, aluno);
if (updatedAluno != null) {
return ResponseEntity.ok(updatedAluno);
} else {
return ResponseEntity.notFound().build();
}
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteAluno(@PathVariable Long id) {
boolean deleted = alunoService.deletealuno(id);
if (deleted) {
return ResponseEntity.ok().body("o Aluno foi excluído com sucesso.");
} else {
return ResponseEntity.notFound().build();
}
}


}
