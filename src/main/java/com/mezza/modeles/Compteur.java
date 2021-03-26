package com.mezza.modeles;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="compteur")
@NamedQuery(name="Compteur.findAll", query="SELECT u FROM Compteur u")
public class Compteur {
	
	@Id
	private String tablename;
	private int nextid;
	
	public Compteur() {
		super();
	}
	public Compteur(String nameTable, int nextval) {
		super();
		this.tablename = nameTable;
		this.nextid = nextval;
	}
	public String getNameTable() {
		return tablename;
	}
	public void setNameTable(String nameTable) {
		this.tablename = nameTable;
	}
	public int getNextval() {
		return nextid;
	}
	public void setNextval(int nextval) {
		this.nextid = nextval;
	}
	@Override
	public String toString() {
		return "Compteur [nameTable=" + tablename + ", nextval=" + nextid + "]";
	}
	
	
}
