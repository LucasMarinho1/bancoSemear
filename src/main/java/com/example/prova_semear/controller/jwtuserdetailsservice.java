package com.example.prova_semear.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.prova_semear.dao.repositorio;
import com.example.prova_semear.modal.usuario;

@Service
public class jwtuserdetailsservice implements UserDetailsService {
	@Autowired
	private repositorio Repositorio;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		usuario usuario = Repositorio.findUsuario(nome);
		
		if (usuario != null) {
			return new User(usuario.getNome(), usuario.getSenha(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado com o nome: " + nome);
		}
	}
}
