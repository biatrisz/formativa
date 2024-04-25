package com.avaliacaodois.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	private final AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaalunoControlId(@PathVariable Long id){
		Aluno aluno = alunoService.getalunoById(id);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		}
		else {
			return ResponseEntity.notFound().build();		
		}

	}
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Aluno>>buscaAlunosporCidade(@PathVariable String cidade){
		List <Aluno> aluno = alunoService.getAllalunoPorCidade(cidade);
		return ResponseEntity.ok(aluno);
	}

	@GetMapping("/renda/{renda}")
	public ResponseEntity<List<Aluno>>buscaAlunosporRenda(@PathVariable double renda){
	List <Aluno> aluno = alunoService.getAllalunoPorRenda(renda);
	return ResponseEntity.ok(aluno);
	}

	@GetMapping("/ra/{ra}")
	public ResponseEntity <Aluno> buscaAlunosporra(@PathVariable String ra){
	 Aluno aluno = alunoService.getAllalunoPorRA(ra);
	return ResponseEntity.ok(aluno);
	}

	@GetMapping("/cidadeerenda/{cidadeerenda}")
	public ResponseEntity<List<Aluno>>buscaAlunosporCidadeAndRenda(@PathVariable String cidade, @PathVariable  renda){
	List <Aluno> aluno = alunoService.getAllalunoPorCidadeAndRenda(cidade,renda);
	return ResponseEntity.ok(aluno);
	}
	@PostMapping("/")
	public ResponseEntity<Aluno> salvaalunoControl(@RequestBody @Validated Aluno aluno){
		Aluno salvaaluno = alunoService.salvaraluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaaluno);
	}
		@PutMapping("/{id}")
		public ResponseEntity<Aluno> alteraalunoControl(@PathVariable Long id, @RequestBody @Validated Aluno aluno){
			Aluno alteraaluno = alunoService.updatealuno(id, aluno);
			if(alteraaluno != null) {
				return ResponseEntity.ok(aluno);
			}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> apagapdutoControl(@PathVariable  Long id){
		boolean apagar = alunoService.deletealuno(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
