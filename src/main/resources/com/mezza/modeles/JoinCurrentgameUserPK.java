package com.mezza.modeles;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the join_currentgame_users database table.
 * 
 */
@Embeddable
public class JoinCurrentgameUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="partie_id", insertable=false, updatable=false)
	private int partieId;

	@Column(insertable=false, updatable=false)
	private int utilisateurList_id;

	public JoinCurrentgameUserPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JoinCurrentgameUserPK)) {
			return false;
		}
		JoinCurrentgameUserPK castOther = (JoinCurrentgameUserPK)other;
		return 
			(this.partieId == castOther.partieId)
			&& (this.utilisateurList_id == castOther.utilisateurList_id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.partieId;
		hash = hash * prime + this.utilisateurList_id;
		
		return hash;
	}
}