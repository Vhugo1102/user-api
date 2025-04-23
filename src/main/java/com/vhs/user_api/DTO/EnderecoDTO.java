package com.vhs.user_api.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

/** DTO que representa um endereço. */
@Schema(name = "EnderecoDTO", description = "Dados do endereço do usuário")
public class EnderecoDTO {

	@Schema(example = "1")
	private Long id;

	@Schema(example = "Rua das Flores")
	private String rua;

	@Schema(example = "123")
	private String numero;

	@Schema(example = "Centro")
	private String bairro;

	@Schema(example = "São Paulo")
	private String cidade;

	@Schema(example = "SP")
	private String estado;

	/* Construtores */
	public EnderecoDTO() {
	}

	public EnderecoDTO(Long id, String rua, String numero, String bairro, String cidade, String estado) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	/* Getters e Setters */
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
