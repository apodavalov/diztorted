package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(
		uniqueConstraints = { 
				@UniqueConstraint(columnNames = { "album_id", "split_id"}),  
				@UniqueConstraint(columnNames = { "split_id", "num"})
		}
)
public class SplitAlbum extends Model {
	private static final long serialVersionUID = -7810027196899616339L;

	@Id
	private Long id;
	
	@ManyToOne
	@Required
	@NotNull
	private Album album;
	
	@ManyToOne
	@Required
	@NotNull
	private Split split;
	
	@Required
	@NotNull
	private Integer num;

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Split getSplit() {
		return split;
	}

	public void setSplit(Split split) {
		this.split = split;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getId() {
		return id;
	}
}
