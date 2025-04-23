package com.vhs.user_api.entity;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/** Entidade que representa tabela Usuario */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id único do usuário", example = "1")
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    @Column(nullable = false, length = 100)
    @Schema(description = "Nome completo do usuário", example = "Vitor Hugo da Silva")
    private String nome;

    @NotNull(message = "Email não pode ser nulo")
    @Email(message = "Email inválido")
    @Size(min = 5, max = 120, message = "Email deve ter entre 5 e 120 caracteres")
    @Column(nullable = false, unique = true, length = 120)
    @Schema(description = "Email do usuário", example = "joao.silva@email.com")
    private String email;

    @NotNull(message = "Data de nascimento não pode ser nula")
    @Column(name = "data_nascimento")
    @Schema(description = "Data de nascimento do usuário", example = "1990-05-15")
    private LocalDate dataNascimento;

    @NotEmpty(message = "Telefone não pode ser vazio")
    @Size(min = 10, max = 15, message = "Telefone deve ter entre 10 e 15 caracteres")
    @Column(nullable = false, length = 15)
    @Schema(description = "Telefone do usuário", example = "11987654321")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @Schema(description = "Endereço do usuário")
    private Endereco endereco;

    // Construtor vazio exigido pelo JPA
    public Usuario() {
    }

    // Construtor útil
    public Usuario(String nome, String email, LocalDate dataNascimento, String telefone, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /* Getters e setters */
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
