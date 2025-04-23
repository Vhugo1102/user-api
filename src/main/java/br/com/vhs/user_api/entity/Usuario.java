package br.com.vhs.user_api.entity;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/** Entidade que representa tabela Usuario */
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Id unico do usuario", example = "1")
	private Long id;

	@NotNull
	@Size(min = 2, max = 100)
	@Column(nullable = false, length = 100)
	@Schema(description = "Nome completo do usuário", example = "Vitor Hugo da Silva")
	private String nome;

	@NotNull
	@Size(min = 5, max = 120)
	@Column(nullable = false, unique = true, length = 120)
	@Schema(description = "Email do usuário", example = "joao.silva@email.com")
	private String email;

	@Column(name = "data_nascimento")
	@Schema(description = "Data de nascimento do usuário", example = "1990-05-15")
	private LocalDate dataNascimento;

	@ManyToOne
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	@Schema(description = "Endereço do usuário")
	private Endereco endereco;

	// construtor vazio exigido pelo JPA
	public Usuario() {

	}

	// construtor útil
	public Usuario(String nome, String email, LocalDate dataNascimento, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}
	
	/* getters e setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
