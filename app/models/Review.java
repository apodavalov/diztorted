package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Review extends Model implements Noveltiable {
	private static final long serialVersionUID = 4838970528612160732L;

	@Id
	private Long id;
	
	@ManyToOne
	@Required
	@Column(nullable = false)
	private Split split;
	
	@Lob
	@Required
	@Column(nullable = false)
	private String text;
	
	@Required
	@Column(nullable = false)
	private Date postDate;
	
	@Required
	@ManyToOne
	@Column(nullable = false)
	private User user;
	
	@Required
	@Column(nullable = false)
	private String author;
	
	@Required
	@Column(nullable = false)
	private Boolean published;
	
	@Required
	@Column(nullable = false)
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

	@Override
	public String getName() {
		if (split == null)
			return null;
		
		return split.getFullName();
	}
}
