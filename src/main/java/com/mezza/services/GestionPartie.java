package com.mezza.services;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.mezza.modeles.Partie;
import com.mezza.modeles.Utilisateur;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/Partie")
public class GestionPartie {
	
	ServicePartieDAOImpl  dao = new ServicePartieDAOImpl();
	Gson g = new Gson();
	
	public GestionPartie ()
	{
	}

	@GET
	@Path("/")
	@Produces (MediaType.APPLICATION_JSON)
	public Response liretout()
	{
		return Response.status(200).entity(g.toJson(dao.getallGame())).build();
	}	

	@GET
	@Path("/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response lire(@PathParam("id") int id)
	{
		return Response.status(200).entity(g.toJson(dao.getGame(id))).build();
	}	
	
	@GET
	@Path("/partie/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response lirePartie(@PathParam("id") int id)
	{
		return Response.status(200).entity(g.toJson(dao.getGameByUsers(id))).build();
	}	

	@POST
	@Path("/")
	@Produces (MediaType.APPLICATION_JSON)
	public String ajouter(String data)
	{
		System.out.println(data);
//		 convertir string json en Personne
		Partie p = g.fromJson(data, Partie.class);
//		 Ajouter Personne � la liste
		dao.addPartie(p);
		return "OK";
	}	
	
	// id => Personne  {id, nom}

	@PUT
	@Path("/")
	@Produces (MediaType.APPLICATION_JSON)
	public String modifier(String data)
	{
//		System.out.println("Modification");
//		System.out.println(data);
//		Utilisateur p = g.fromJson(data, Utilisateur.class);
//		System.out.println(p);
		return "ok";
	}	
	
	@DELETE
	@Path("/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public String supprimer (@PathParam("id") String email)
	{
		
//		System.out.println("supprimer");
//		return dao.DeletUser(email);
		return "ok";
	}	
	
}
