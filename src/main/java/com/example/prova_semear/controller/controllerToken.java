package com.example.prova_semear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova_semear.config.security.JwtTokenUtil;
import com.example.prova_semear.modal.jwtresponse;
import com.example.prova_semear.modal.usuario;

@RestController
@CrossOrigin
public class controllerToken {
	
	
	//@Autowired
	//private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private jwtuserdetailsservice userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody usuario authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getNome(), authenticationRequest.getSenha());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getNome());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new jwtresponse(token));
	}
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			//trecho retirado devido ao conflito do h2 e jwt
			//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException e) {
			throw new Exception("USUARIO_DESATIVADO", e);
		} catch (BadCredentialsException e) {
			throw new Exception("CREDENCIAIS_INVALIDAS", e);
		}
	}
	

}