package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Comment extends Model {
	private static final long serialVersionUID = -1365461110927218152L;

	@Id
	private Long id;
	
	@Column
	@ManyToOne
	private Comment parent;
	
	@Required
	@Column(nullable = false)
	private String login;
	
	@Required
	@Column(nullable = false)
	private Boolean member;
	
	@Lob
	@Required
	@Column(nullable = false)
	private String text;
	
	@Required
	@Column(nullable = false)
	private Date postDate;
	
	@Required
	@Column(nullable = false)
	private User approvedBy;

	public Comment getParent() {
		return parent;
	}

	public void setParent(Comment parent) {
		this.parent = parent;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getMember() {
		return member;
	}

	public void setMember(Boolean member) {
		this.member = member;
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

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Long getId() {
		return id;
	}
}
