package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_carte;

	private String numero;
	private String code_secret;
	private Date date_exp;
	
	public Carte(int id_carte, String numero, String code_secret, Date date_exp) {
		super();
		this.id_carte = id_carte;
		this.numero = numero;
		this.code_secret = code_secret;
		this.date_exp = date_exp;
	}

	public Carte() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Carte [id_carte=" + id_carte + ", numero=" + numero + ", code_secret=" + code_secret + ", date_exp="
				+ date_exp + "]";
	}

	public int getId_carte() {
		return id_carte;
	}

	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCode_secret() {
		return code_secret;
	}

	public void setCode_secret(String code_secret) {
		this.code_secret = code_secret;
	}

	public Date getDate_exp() {
		return date_exp;
	}

	public void setDate_exp(Date date_exp) {
		this.date_exp = date_exp;
	}

}
