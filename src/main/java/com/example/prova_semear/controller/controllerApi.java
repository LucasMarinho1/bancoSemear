package com.example.prova_semear.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova_semear.dao.repositorio;
import com.example.prova_semear.dao.repositorioanuncio;
import com.example.prova_semear.dao.repositorioresumoanuncio;
import com.example.prova_semear.modal.anuncio;
import com.example.prova_semear.modal.resumoanuncios;
import com.example.prova_semear.modal.usuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Controller Api
 * 
 * @author Lucas
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "Api Rest Usuarios/Anuncios")
public class controllerApi {

	@Autowired
	private repositorio Repositorio;
	@Autowired
	private repositorioanuncio RepositorioAnuncio;
	@Autowired
	private repositorioresumoanuncio RepositorioResumoAnuncio;
	
	@ApiOperation(value = "Cadastro de Usuarios")
    @RequestMapping(method=RequestMethod.POST, value="/cadastroUser", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@RequestBody usuario usuario) {

        Repositorio.save(usuario);

        return ResponseEntity.ok("Usuario cadastrado!");
    }
    
	@ApiOperation(value = "Consulta de usuarios (findall)")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna a lista de usuarios"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
    @GetMapping(value = "consultarUser")
	@Cacheable(value = "consultUser")
	public Iterable<usuario> consultUser(Model model) {
    	Iterable<usuario> results =  Repositorio.findAll();
       
		return results;

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cadastroanuncio")
    public ResponseEntity<String> saveAnuncio(@RequestBody anuncio anuncio) {

		RepositorioAnuncio.save(anuncio);

        return ResponseEntity.ok("Anuncio cadastrado!");
    }
	
	@GetMapping(value = "consultarAnuncio")
	@Cacheable(value = "consultAnuncio")
	public Iterable<anuncio> consultAnuncio(Model model) {
    	Iterable<anuncio> results =  RepositorioAnuncio.findAll();
       
		return results;

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/raioanuncio")
	
    public List<anuncio> raioAnuncio(@RequestBody anuncio anuncio) {
    	List<anuncio> list = new ArrayList<>();
    	
    	Iterator<anuncio> result = RepositorioAnuncio.findAll().iterator();
    	 while (result.hasNext()) {
             anuncio str = result.next();
             
             double raio = calcularaio(anuncio,str);
             
             if (raio < 0.0015) {
            	 list.add(str);
			}
          }
        return  list;
    }
    
    @Cacheable(value = "calcularaio")
    public double calcularaio (anuncio anuncio, anuncio str) {
    	return (6371 * Math.acos(
       		 Math.cos(Math.toRadians(anuncio.getLatitude()))*
       		 Math.cos(Math.toRadians(str.getLatitude()))*
       		 Math.cos(Math.toRadians(anuncio.getLongitude())-Math.toRadians(str.getLongitude()))+
       		 Math.sin(Math.toRadians(anuncio.getLatitude())) *
       		 Math.sin(Math.toRadians(str.getLatitude()))
       		 ));
    }
    
	/* Contador foi feito desta forma, pois devido a quantidade de acessos poderia duplicar os registros do contador
	 * se eu gravasse na base de dados, e desta forma alem de um relatorio de historico, eu poderia exibir um resumo
	 * detalhado usando um SUM*/
	
	@RequestMapping(method=RequestMethod.POST, value="/sumvizualizacoes")
	public void somaVizualizacoes(anuncio anuncio) {
		
		resumoanuncios resumoanuncio = new resumoanuncios();
		resumoanuncio.setNomeanunciante(anuncio.getNomeanunciante());
		resumoanuncio.setDatahora(new Date(System.currentTimeMillis()));
		RepositorioResumoAnuncio.save(resumoanuncio);

	}
}
