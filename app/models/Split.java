package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.QueryIterator;

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

	public String getFullName() {
		return String.format("%1$s [ %2$s ]", getBandString(), getNameString());
	}
	
	public String getBandString() {
		Album[] albums = findAlbums();
		
		if (albums.length == 0)
			return "V/A";
		
		StringBuilder bands = new StringBuilder();
		
		for (int i = 0; i < albums.length; i++)
		{
			if (i != 0)
				bands.append(" / ");
			
			bands.append(albums[i].getBand().getName());
		}
		
		return bands.toString();
	}

	public String getOriginString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getNameString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Album[] findAlbums() {
		if (id == null)
			return new Album[0];
		
		QueryIterator<SplitAlbum> iterator = SplitAlbum.getFinder().
			where().eq("split_id", id).
			orderBy("num asc").findIterate();
		
		List<Album> albums = new ArrayList<Album>();
		
		while (iterator.hasNext())
			albums.add(iterator.next().getAlbum());
		
		return albums.<Album>toArray(new Album[albums.size()]);
	}
}
