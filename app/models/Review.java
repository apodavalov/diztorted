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
public class Review extends Model {
	private static final long serialVersionUID = 4838970528612160732L;

	@Id
	private Long id;
	
	@ManyToOne
	@Required
	@NotNull
	private Split split;
	
	@Lob
	@Required
	@NotNull
	private String text;
	
	@Required
	@NotNull
	private Date postDate;
	
	@Required
	@ManyToOne
	@NotNull
	private User user;
	
	@Required
	@NotNull
	private String author;
	
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

	public Split getSplit() {
		return split;
	}

	public void setSplit(Split split) {
		this.split = split;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
