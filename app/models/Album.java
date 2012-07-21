package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Album extends Model {
	private static final long serialVersionUID = 5376662913438191827L;

	@Id
	private Long id;
	
	@Required
	@ManyToOne
	@Column(nullable = false)
	private Band band;
	
	@Required
	@Column(nullable = false)
	private String name;
	
	@Required
	@Column(nullable = false)
	private String style;

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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Long getId() {
		return id;
	}
}
