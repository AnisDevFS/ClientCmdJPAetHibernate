package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.entities.Client;

@Entity
public class Commande {
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_commande;
	private String produit;
	private int nombre;
	private int prix;
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client") 
	private Client client;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(int id_commande, String produit, int nombre, int prix, Date date, Client client) {
		super();
		this.id_commande = id_commande;
		this.produit = produit;
		this.nombre = nombre;
		this.prix = prix;
		this.date = date;
		this.client = client;
	}
	


	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", produit=" + produit + ", nombre=" + nombre + ", prix=" + prix
				+ ", date=" + date + ", client=" + client + "]";
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
