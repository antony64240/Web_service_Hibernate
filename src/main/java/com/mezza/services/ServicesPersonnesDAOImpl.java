package com.mezza.services;


import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mezza.modeles.Utilisateur;


public class ServicesPersonnesDAOImpl implements ServiceUtilisateurDAO {

	//private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Utilisateurs2db");
	EntityManagerFactory ENTITY_MANAGER_FACTORY= null;
	public ServicesPersonnesDAOImpl ()
	{
		ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("user");
	}
	
	public List<Utilisateur> GetUsers() {
		List<Utilisateur> Utilisateurs = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();
			TypedQuery<Utilisateur> query = manager.createNamedQuery("Utilisateur.findAll", Utilisateur.class);
			Utilisateurs = query.getResultList();
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return Utilisateurs;
	}

	public Utilisateur GetUser(int id) {
		Utilisateur Utilisateur = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();
			TypedQuery<Utilisateur> query = manager.createNamedQuery("Utilisateur.findAll", Utilisateur.class);
			Utilisateur = (Utilisateur) query.getResultList().get(0);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return Utilisateur;
	}

	public String AddUser(Utilisateur p) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(p);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return "OK";
	}

	public String UpdateUsers(Utilisateur p) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(p);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return "OK";
	}

	public String DeletUser(String email) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();
			transaction.begin();
			Utilisateur p = manager.find(Utilisateur.class, email);
			manager.remove(p);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return "OK";
	}

	
	

}

