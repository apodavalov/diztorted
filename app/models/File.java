package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class File extends Model {
	private static final long serialVersionUID = 659588489962684809L;

	@Id
	private Long id;
	
	@Required
	@NotNull
	private String name;
	
	@Required
	@NotNull
	private String extension;
	
	@Required
	@NotNull
	private String mimeType;
	
	@Lob
	@Required
	@NotNull
	private byte[] content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}
}
