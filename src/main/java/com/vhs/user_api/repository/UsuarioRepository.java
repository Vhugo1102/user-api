package com.vhs.user_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vhs.user_api.entity.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	boolean existsByEmail(String email);    // exemplo de consulta específica
}
