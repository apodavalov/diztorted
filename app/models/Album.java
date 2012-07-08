package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Album extends Model {
	private static final long serialVersionUID = 5376662913438191827L;

	@Id
	private Long id;
	
	@Required
	@ManyToOne
	@NotNull
	private Band band;
	
	@Required
	@NotNull
	private String name;
	
	@Required
	@NotNull
	private String styleName;

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public Long getId() {
		return id;
	}
}
