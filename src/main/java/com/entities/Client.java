package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.entities.Commande;
import com.entities.Voiture;

@Entity @Table (name ="client")
public class Client {



	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_client;
	private String nom;
	
	@Column (name ="mail")
	private String email;
	private String password;
	private int  age;
	
    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_client") 
    private List<Commande> commandes = new ArrayList<>();
    
    @OneToOne( cascade = CascadeType.ALL )  
    @JoinColumn( name="id_compte")
    private Compte compte;
    
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "clientsVoitures",
    			joinColumns = @JoinColumn (name = "id_client"),
                inverseJoinColumns = @JoinColumn( name = "id_voiture"))
    private List<Voiture> voitures = new ArrayList<>();
    
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client( String nom, String email, String password, int age) {
		super();
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.age = age;
	}

	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public List<Voiture> getVoitures() {
		return voitures;
	}


	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}


	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nom=" + nom + ", email=" + email + ", password=" + password
				+ ", age=" + age + "]";
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
    
	

}
