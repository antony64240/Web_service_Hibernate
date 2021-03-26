package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the view_usergame database table.
 * 
 */
@Entity
@Table(name="view_usergame")
@NamedQuery(name="ViewUsergame.findAll", query="SELECT v FROM ViewUsergame v")
public class ViewUsergame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="partie_id")
	private int partieId;

	private int utilisateurList_id;

	public ViewUsergame() {
	}

	public int getPartieId() {
		return this.partieId;
	}

	public void setPartieId(int partieId) {
		this.partieId = partieId;
	}

	public int getUtilisateurList_id() {
		return this.utilisateurList_id;
	}

	public void setUtilisateurList_id(int utilisateurList_id) {
		this.utilisateurList_id = utilisateurList_id;
	}

}