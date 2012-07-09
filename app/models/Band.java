package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Band extends Model {
	private static final long serialVersionUID = -426607358843128575L;

	@Id
	private Long id;
	
	@Required
	@Column(nullable = false)
	private String name;
	
	@Column
	private String origin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Long getId() {
		return id;
	}
}
