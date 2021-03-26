package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the join_currentgame_users database table.
 * 
 */
@Entity
@Table(name="join_currentgame_users")
@NamedQuery(name="JoinCurrentgameUser.findAll", query="SELECT j FROM JoinCurrentgameUser j")
public class JoinCurrentgameUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JoinCurrentgameUserPK id;

	public JoinCurrentgameUser() {
	}

	public JoinCurrentgameUserPK getId() {
		return this.id;
	}

	public void setId(JoinCurrentgameUserPK id) {
		this.id = id;
	}

}