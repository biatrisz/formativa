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


import com.avaliacaodois.entities.Turma;
import com.avaliacaodois.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	private final TurmaService turmaService;

	@Autowired
	public TurmaController(TurmaService turmaService) {
		this.turmaService = turmaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscaturmaControlId(@PathVariable Long id){
		Turma turma = turmaService.getturmaById(id);
		if (turma != null) {
			return ResponseEntity.ok(turma);
		}
		else {
			return ResponseEntity.notFound().build();		
		}

	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Turma>>buscaTurmaporDescricao(@PathVariable String descricao){
	List <Turma> turma = turmaService.getAllturmaPorDescricao(descricao);
	return ResponseEntity.ok(turma);
	}
	@GetMapping("/nomeedescricao/{nomeedescricao}")
	public ResponseEntity<List<Turma>>buscaTurmaporNomeAndDescricao(@PathVariable String nome, double descricao){
	List <Turma> turma = turmaService.getAllturmaPorNomeAndDescricao(nome,descricao);
	return ResponseEntity.ok(turma);
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Turma>>buscaTurmaporNome(@PathVariable String nome){
	List <Turma> turma = turmaService.getAllturmaPorNome(nome);
	return ResponseEntity.ok(turma);
	}
	@GetMapping("/")
	public ResponseEntity<List<Turma>>buscaTodosturmaControl(){
		List <Turma> turma = turmaService.getAllturma();
		return ResponseEntity.ok(turma);
	}
	@PostMapping("/")
	public ResponseEntity<Turma> salvaturmaControl(@RequestBody @Validated Turma turma){
		Turma salvaturma = turmaService.salvarturma(turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaturma);
	}
		@PutMapping("/{id}")
		public ResponseEntity<Turma> alteraturmaControl(@PathVariable Long id, @RequestBody @Validated Turma turma){
			Turma alteraturma = turmaService.updateturma(id, turma);
			if(alteraturma != null) {
				return ResponseEntity.ok(turma);
			}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Turma> apagapdutoControl(@PathVariable  Long id){
		boolean apagar = turmaService.deleteturma(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
