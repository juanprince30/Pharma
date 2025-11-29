package com.prince;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "drugs")
public class Drug {

    @Id
    @GeneratedValue
    private int id;

    private String nom;
    private String category;
    private String image;
    private double prix;
    private int quantite;

    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL)
    private List<Vente> ventes;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL)
    private List<Alerte> alertes;

	public LocalDate getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public List<Vente> getVente() {
		return ventes;
	}

	public void setVente(List<Vente> ventes) {
		this.ventes = ventes;
	}
	
	public List<Alerte> getAlerte() {
		return alertes;
	}

	public void setAlerte(List<Alerte> alertes) {
		this.alertes = alertes;
	}
    
}