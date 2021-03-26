package com.mezza.services;

import java.util.List;

import com.mezza.modeles.Utilisateur;




public interface ServiceUtilisateurDAO {

	public List<Utilisateur> GetUsers();
	public Utilisateur GetUser(int id);
	public String AddUser(Utilisateur p);
	public String UpdateUsers(Utilisateur p);
	public String DeletUser(String email);
	
}
