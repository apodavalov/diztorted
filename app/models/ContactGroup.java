package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class ContactGroup extends Model {
	private static final long serialVersionUID = 6439128699856879097L;

	@Id
	private Long id;
	
	@Required
	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
}
