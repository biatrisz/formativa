package com.avaliacaodois.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table (name = "Aluno")
	public class Aluno {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		
		@Column (name = "cidade", nullable = false)
		private String cidade;
		
		
		@Column (name = "email", nullable = false)
		private String email;
		
		
		@Column (name = "nome", nullable = false)
		private String nome;
		
		
		@Column (name = "ra", nullable = false)
		private String ra;
		
		
		@Column (name = "renda", nullable = false)
		private double renda;
		
		
		@Column (name = "telefone", nullable = false)
		private String telefone;
		
		@ManyToOne
		@JoinColumn(name = "id_Turma", nullable = false)
		private Turma turma;

}