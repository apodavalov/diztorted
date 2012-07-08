package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class News extends Model {
	private static final long serialVersionUID = 272645146840439206L;

	@Id
	private Long id;
	
	@Required
	@NotNull
	private String name;
	
	@Lob
	@NotNull
	private String textBrief;
	
	@Lob
	@Required
	@NotNull
	private String textFull;
	
	@Required
	@NotNull
	private Date postDate;
	
	@Required
	@ManyToOne
	@NotNull
	private User user;
	
	@Required
	@NotNull
	private Boolean published;
	
	@Required
	@NotNull
	private Date lastUpdated;
	
	@ManyToOne
	private Comment firstComment;	
	
	@PreUpdate
	private void PreUpdate()
	{
		lastUpdated = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTextBrief() {
		return textBrief;
	}

	public void setTextBrief(String textBrief) {
		this.textBrief = textBrief;
	}

	public String getTextFull() {
		return textFull;
	}

	public void setTextFull(String textFull) {
		this.textFull = textFull;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Long getId() {
		return id;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public Comment getFirstComment() {
		return firstComment;
	}

	public void setFirstComment(Comment firstComment) {
		this.firstComment = firstComment;
	}
}
