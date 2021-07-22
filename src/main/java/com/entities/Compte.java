package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "compte")
public class Compte {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_compte;
	
	private String reference;
	private  int solde;
	
    @OneToOne( cascade = CascadeType.ALL )  
    @JoinColumn( name="id_carte")
    private Carte carte;
	

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Compte(String reference, int solde) {
		this.reference = reference;
		this.solde = solde;
	}
	
	public Compte() {
	}
	
	public int getId_compte() {
		return id_compte;
	}
	public String getReference() {
		return reference;
	}
	public int getSolde() {
		return solde;
	}
	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}


}
