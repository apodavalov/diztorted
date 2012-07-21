package models;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Split extends Model {
	private static final long serialVersionUID = 4475018267353343070L;

	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String origin;
	
	@Column
	private String style;	
	
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
	
	@OneToMany
	@OrderBy("num asc")
	private List<SplitAlbum> splitAlbums;
	
	@OneToMany
	@OrderBy("num asc")
	private List<SplitLabel> splitLabels;
	
	public List<SplitAlbum> getSplitAlbums() {
		return Collections.unmodifiableList(splitAlbums);
	}
	
	public List<SplitLabel> getSplitLabels() {
		return splitLabels;
	}

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
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
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

	public String getFullName() {
		return String.format("%1$s [ %2$s ]", getBandString(), getNameString());
	}
	
	public String getBandString() {
		if (splitAlbums.size() == 0)
			return "V/A";
		
		StringBuilder bands = new StringBuilder();
		
		for (int i = 0; i < splitAlbums.size(); i++)
		{
			if (i != 0)
				bands.append(" / ");
			
			bands.append(splitAlbums.get(i).getAlbum().getBand().getName());
		}
		
		return bands.toString();
	}

	public String getOriginString() {
		if (origin != null)
			return origin;
		
		if (splitAlbums.size() == 0)
			return null;
		
		StringBuilder bands = new StringBuilder();
		
		for (int i = 0; i < splitAlbums.size(); i++)
		{
			if (i != 0)
				bands.append(" / ");
			
			String value = splitAlbums.get(i).getAlbum().getBand().getOrigin();
			if (value == null)
				value = "<Неизвестно>";
			
			bands.append(value);
		}
		
		return bands.toString();
	}
	
	public String getNameString() {
		if (name != null)
			return name;
		
		if (splitAlbums.size() == 0)
			return "<Без названия>";
		
		StringBuilder bands = new StringBuilder();
		
		for (int i = 0; i < splitAlbums.size(); i++)
		{
			if (i != 0)
				bands.append(" / ");
			
			bands.append(splitAlbums.get(i).getAlbum().getName());
		}
		
		return bands.toString();
	}
	
	public String getStyleString() {
		if (style != null)
			return style;
	
		if (splitAlbums.size() == 0)
			return null;
		
		StringBuilder bands = new StringBuilder();
		
		for (int i = 0; i < splitAlbums.size(); i++)
		{
			if (i != 0)
				bands.append(" / ");
			
			bands.append(splitAlbums.get(i).getAlbum().getStyle());
		}
		
		return bands.toString();
	}	
	
	public String getLabelString() {
		if (splitLabels.size() == 0)
			return null;
		
		StringBuilder bands = new StringBuilder();
		
		for (int i = 0; i < splitLabels.size(); i++)
		{
			if (i != 0)
				bands.append(" / ");
			
			bands.append(splitLabels.get(i).getLabel().getName());
		}
		
		return bands.toString();
	}	
}
