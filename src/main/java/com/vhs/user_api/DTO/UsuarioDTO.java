package com.vhs.user_api.DTO;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

/** DTO que representa um usuário. */
@Schema(name = "UsuarioDTO", description = "Dados do usuário")
public class UsuarioDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "João Silva")
    private String nome;

    @Schema(example = "joao@gmail.com")
    private String email;

    @Schema(example = "1990-05-15")
    private LocalDate dataNascimento;

    @Schema(example = "(11) 98765-4321")
    private String telefone;

    private EnderecoDTO endereco;

    /* Construtores */
    public UsuarioDTO() {}

    public UsuarioDTO(Long id, String nome, String email,
                      LocalDate dataNascimento, String telefone, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /* Getters e Setters */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public EnderecoDTO getEndereco() { return endereco; }
    public void setEndereco(EnderecoDTO endereco) { this.endereco = endereco; }
}
