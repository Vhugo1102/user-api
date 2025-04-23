package br.com.vhs.user_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/** Classe que representa o endereço de um usuário */
@Entity
@Table(name = "enderecos")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "ID único do endereço", example = "1")
	private Long id;

	@NotNull
	@Size(min = 5, max = 200)
	@Column(nullable = false, length = 200)
	@Schema(description = "Rua ou avenida do endereço", example = "Avenida Brasil")
	private String rua;

	@NotNull
	@Size(min = 1, max = 10)
	@Column(nullable = false, length = 10)
	@Schema(description = "Número da casa ou apartamento", example = "123")
	private String numero;

	@NotNull
	@Size(min = 5, max = 50)
	@Column(nullable = false, length = 50)
	@Schema(description = "Bairro do endereço", example = "Centro")
	private String bairro;

	@NotNull
	@Size(min = 5, max = 50)
	@Column(nullable = false, length = 50)
	@Schema(description = "Cidade do endereço", example = "São Paulo")
	private String cidade;

	@NotNull
	@Size(min = 2, max = 10)
	@Column(nullable = false, length = 10)
	@Schema(description = "Estado do endereço", example = "SP")
	private String estado;

	// construtor vazio exigido pelo JPA
	public Endereco() {
	}

	// construtor útil
	public Endereco(String rua, String numero, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	/* getters e setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
