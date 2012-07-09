package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Split extends Model {
	private static final long serialVersionUID = 4475018267353343070L;

	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Required
	@Column(nullable = false)
	private Integer year;
	
	@Required
	@Column(nullable = false)
	private Integer duration;
	
	@ManyToOne
	private File cover;
	
	@Lob
	@Required
	@Column(nullable = false)	
	private String trackList;
	
	@Required
	@Column(nullable = false)	
	private Boolean trackListNormal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String getTrackList() {
		return trackList;
	}

	public void setTrackList(String trackList) {
		this.trackList = trackList;
	}

	public Boolean getTrackListNormal() {
		return trackListNormal;
	}

	public void setTrackListNormal(Boolean trackListNormal) {
		this.trackListNormal = trackListNormal;
	}

	public Long getId() {
		return id;
	}
}
