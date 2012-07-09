package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Banner extends Model {
	private static final long serialVersionUID = -2529346916384965457L;

	@Id
	private Long id;
	
	@Column
	private String text;
	
	@Required
	@Column(nullable = false)
	private Contact contact;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}
}
