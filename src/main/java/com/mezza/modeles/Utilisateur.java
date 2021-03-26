package com.mezza.modeles;

import java.sql.Timestamp;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="utilisateur")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur {
	
	
	public Utilisateur() {
	}
	
	
	@Id
	@GeneratedValue(generator="UtilisateurGenerator")
	@TableGenerator(name="UtilisateurGenerator",
	                table="compteur",
	                pkColumnName = "tablename",
	                pkColumnValue = "utilisateur",
	                valueColumnName = "nextid",
	                allocationSize = 1
	                )
	private int id;
	private String Nom;
	private String Prenom;
	private String Email;
	private String Password;
	@Column(insertable = false)
	private Timestamp creerle;


	
	public Utilisateur(String nom, String prenom, String email, String password) {
		Nom = nom;
		Prenom = prenom;
		Email = email;
		Password = password;
	}
	
	

	public Utilisateur(String email) {
		this.Email=email;
	}
	
	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom  + ", Email="
				+ Email + ", Password=" + Password
				 + ", creerle=" + creerle + "]";
	}


	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
