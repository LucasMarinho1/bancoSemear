package com.example.prova_semear.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.prova_semear.modal.usuario;

public interface repositorio extends CrudRepository<usuario, Integer>{
	
	@Query("SELECT u FROM usuario u WHERE u.nome = :nome")
	usuario findUsuario(@Param("nome") String nome);
	
}
