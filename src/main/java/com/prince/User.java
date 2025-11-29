package com.prince;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String nom;
    private String prenom;

    @Column(unique = true)
    private String email;
    private String password;

    @Column(name = "telephone", unique = true)
    private String numeroTelephone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Drug> drugs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Vente> ventes;
	
	public User() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	public String getTelephone() {
		return numeroTelephone;
	}

	public void setTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	
	public List<Drug> getDrug() {
		return drugs;
	}

	public void setDrug(List<Drug> drugs) {
		this.drugs = drugs;
	}
	
	public List<Vente> getVente() {
		return ventes;
	}

	public void setVente(List<Vente> ventes) {
		this.ventes = ventes;
	}

}
