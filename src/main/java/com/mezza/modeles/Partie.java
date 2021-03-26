package com.mezza.modeles;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;




@Entity
@Table(name="partie")
@NamedQueries({
@NamedQuery(name="Partie.findAll", query="SELECT u FROM Partie u"),
@NamedQuery(name="Partie.findbyUser", query = "SELECT p FROM Partie p join  p.utilisateurList u where u.id = ?1")
})
public class Partie {

	@Id
	@GeneratedValue(generator="PartieGenerator")
	@TableGenerator(name="PartieGenerator",
	                table="compteur",
	                pkColumnName = "tablename",
	                pkColumnValue = "partie",
	                valueColumnName = "nextid",
	                allocationSize = 1
	                )
	private int id;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Join_CurrentGame_Users", joinColumns={@JoinColumn(referencedColumnName="id")}
                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="id")}) 
	private Set<Utilisateur> utilisateurList;
	
	public Set<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}
	public void setUtilisateurList(Set<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}
	private int TourJoueur;
	private int nombreCoup;
	
	
	@Column(insertable = false)
	private Timestamp creele;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public Partie(int id, int idJoueur1, int idJoueur2, int vainqueur, int nombreCoup) {
		super();
		this.id = id;
		this.nombreCoup = nombreCoup;
	}
	public Partie() {
		super();
	}

	
	public int getNombreCoup() {
		return nombreCoup;
	}
	public void setNombreCoup(int nombreCoup) {
		this.nombreCoup = nombreCoup;
	}
	public int getTourJoueur() {
		return TourJoueur;
	}
	public void setTourJoueur(int tourJoueur) {
		TourJoueur = tourJoueur;
	}
	
}
