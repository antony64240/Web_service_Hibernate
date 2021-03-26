package com.mezza.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.SQLQuery;

import com.mezza.modeles.Partie;
import com.mezza.modeles.Utilisateur;


public class ServicePartieDAOImpl implements ServicePartieDAO{

	
	public ServicePartieDAOImpl() {
		ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("user");
	}

	EntityManagerFactory ENTITY_MANAGER_FACTORY= null;
	@Override
	public List<Partie> getallGame() {
		List<Partie> partie = null;
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
     
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			TypedQuery<Partie> query = manager.createNamedQuery("Partie.findAll", Partie.class);
			partie = query.getResultList();
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return partie;
	}

	@Override
	public String addPartie(Partie p) {
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

	@Override
	public Partie getGame(int id) {
		Partie partie = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();
			TypedQuery<Partie> query = manager.createNamedQuery("Partie.findAll", Partie.class);
			partie = (Partie) query.getResultList().get(0);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return partie;
	}
	
	
	@Override
	public List<Partie> getGameByUsers(int id) {
		List<Partie> partie = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;
		String sql = String.format("Select p from Partie p join p.utilisateurList u where u.id =  %d ", id);
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			
			TypedQuery<Partie> query = manager.createQuery(sql, Partie.class);
			partie = (List<Partie>) query.getResultList();
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return partie;
	}
	

}
