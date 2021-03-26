package com.mezza.services;

import java.util.List;

import com.mezza.modeles.Partie;

public interface ServicePartieDAO {
	public List<Partie> getallGame();
	public String addPartie(Partie p);
	public Partie getGame(int id);
	public List<Partie> getGameByUsers(int id);

}
