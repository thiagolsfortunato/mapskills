package br.gov.sp.fatec.mapskills.question;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1796697684098689221L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "que_id")
	private Integer id;
	
	@Column(name = "que_description", nullable = false)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="que_id")
	private List<Alternative> alternatives;
	
	@Column(name = "que_index", nullable = false, unique = true)
	private Integer index;
	
	@Column(name = "ski_id", nullable = false)
	private Integer skillId;
	
	@Column(name = "que_isAtive", nullable = false)
	private Boolean isAtive;
	
	public Question() {}
	
	public Question(final String description, final List<Alternative> alternatives, final Integer skillId, final Integer index) {
		this.description = description;
		this.alternatives = alternatives;
		this.skillId = skillId;
		this.index = index;
		this.isAtive = true;
	}
	
	public Integer id() {
		return id;
	}
	
	public String description() {
		return description;
	}
	
	public Integer index() {
		return index;
	}
	
	public void changeDescription(final String newDescription) {
		this.description = newDescription;
	}
	
	public void changeAlternatives(final List<Alternative> newAlternatives) {
		final int size = alternatives.size();
		for(int i = 0; i < size; i++) {
			this.alternatives.get(i).changeDescription(newAlternatives.get(i).description());
			this.alternatives.get(i).changeSkillValue(newAlternatives.get(i).skillValue());
		}
	}
	
	public void changeIndex(final Integer newIndex) {
		this.index = newIndex;
	}
	
	public void setStatus(final Boolean status) {
		this.isAtive = status;
	}

}
