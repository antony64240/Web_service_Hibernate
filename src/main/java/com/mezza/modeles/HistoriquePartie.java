package com.mezza.modeles;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "HistoriquePartie")
@NamedQuery(name = "HistoriquePartie.findAll", query = "SELECT u FROM HistoriquePartie u")
public class HistoriquePartie {

	@Id
	private int id;

	@ManyToMany
	@JoinTable(name = "Join_History_Users", joinColumns = {
			@JoinColumn(referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "id") })
	private List<Utilisateur> utilisateurList;

	private int TourJoueur;
	private int nombreCoup;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}
	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}
	public int getTourJoueur() {
		return TourJoueur;
	}
	public void setTourJoueur(int tourJoueur) {
		TourJoueur = tourJoueur;
	}
	public int getNombreCoup() {
		return nombreCoup;
	}
	public void setNombreCoup(int nombreCoup) {
		this.nombreCoup = nombreCoup;
	}
	public Timestamp getCreele() {
		return creele;
	}
	public void setCreele(Timestamp creele) {
		this.creele = creele;
	}
	private Timestamp creele;
}
