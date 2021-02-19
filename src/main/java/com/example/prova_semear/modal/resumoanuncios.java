package com.example.prova_semear.modal;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class resumoanuncios {

	@Id
	@GeneratedValue
	private int id;
	private String nomeanunciante;
	private Date datahora;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeanunciante() {
		return nomeanunciante;
	}
	public void setNomeanunciante(String nomeanunciante) {
		this.nomeanunciante = nomeanunciante;
	}
	public Date getDatahora() {
		return datahora;
	}
	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}
}
