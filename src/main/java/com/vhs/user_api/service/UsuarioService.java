package com.vhs.user_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhs.user_api.entity.Endereco;
import com.vhs.user_api.entity.Usuario;
import com.vhs.user_api.repository.EnderecoRepository;
import com.vhs.user_api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    /* ---------- CRUD ---------- */

    /** Cria usuário e respectivo endereço */
    public Usuario criar(Usuario usuario) {
        Endereco salvo = enderecoRepository.save(usuario.getEndereco());
        usuario.setEndereco(salvo);
        return usuarioRepository.save(usuario);
    }

    /** Lista todos os usuários */
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    /** Edita usuário e endereço vinculados */
    public Usuario editar(Long id, Usuario dados) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        usuario.setDataNascimento(dados.getDataNascimento());
        usuario.setTelefone(dados.getTelefone());

        Endereco e = usuario.getEndereco();
        Endereco de = dados.getEndereco();
        e.setRua(de.getRua());
        e.setNumero(de.getNumero());
        e.setBairro(de.getBairro());
        e.setCidade(de.getCidade());
        e.setEstado(de.getEstado());
        enderecoRepository.save(e);

        return usuarioRepository.save(usuario);
    }
    
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id)); // Retorna o usuário ou lança uma exceção se não encontrado
    }

    /** Deleta usuário (e opcionalmente o endereço) */
    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // remover o endereço sem usuário no banco:
        Endereco end = usuario.getEndereco();
        usuarioRepository.delete(usuario);
        if (end != null) {
            enderecoRepository.delete(end);
        }
    }
}
