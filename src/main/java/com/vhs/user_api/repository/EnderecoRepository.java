package com.vhs.user_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vhs.user_api.entity.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
