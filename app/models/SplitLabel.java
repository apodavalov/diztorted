package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(
		uniqueConstraints = { 
				@UniqueConstraint(columnNames = { "label_id", "split_id"}),  
				@UniqueConstraint(columnNames = { "split_id", "num"})
		}
)
public class SplitLabel extends Model {
	private static final long serialVersionUID = -6493427159847666950L;

	@Id
	private Long id;
	
	@ManyToOne
	@Required
	@Column(nullable = false)
	private Label label;
	
	@ManyToOne
	@Required
	@Column(nullable = false)
	private Split split;
	
	@Required
	@Column(nullable = false)
	private Integer num;

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
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
