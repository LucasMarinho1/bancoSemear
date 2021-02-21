package com.example.prova_semear.modal;

import java.io.Serializable;

public class jwtresponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public jwtresponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
