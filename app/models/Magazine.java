package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Magazine extends Model {
	private static final long serialVersionUID = -178169861089901755L;

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
