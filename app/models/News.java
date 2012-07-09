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
public class News extends Model {
	private static final long serialVersionUID = 272645146840439206L;

	@Id
	private Long id;
	
	@Required
	@Column(nullable = false)
	private String name;
	
	@Lob
	@Column(nullable = false)
	private String textBrief;
	
	@Lob
	@Required
	@Column(nullable = false)
	private String textFull;
	
	@Required
	@Column(nullable = false)
	private Date postDate;
	
	@Required
	@ManyToOne
	@Column(nullable = false)
	private User user;
	
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
