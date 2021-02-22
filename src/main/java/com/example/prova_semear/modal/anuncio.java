package com.example.prova_semear.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class anuncio {

	@Id
	@GeneratedValue
	private int id;
	private float longitude;
	private float latitude;
	private String nomeanunciante;
	private String texto;
	
	
	
	//ja recebo a imagem na base64, pois ira diminuir o trafego de dados entra api e app
	@Lob
    @Column(name = "imagembase64", length = 5000)
	private byte[] imagembase64;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getNomeanunciante() {
		return nomeanunciante;
	}
	public void setNomeanunciante(String nomeanunciante) {
		this.nomeanunciante = nomeanunciante;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public byte[] getImagembase64() {
		return imagembase64;
	}
	public void setImagembase64(byte[] imagembase64) {
		this.imagembase64 = imagembase64;
	}


}
