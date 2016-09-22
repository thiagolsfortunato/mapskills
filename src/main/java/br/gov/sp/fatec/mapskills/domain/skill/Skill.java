package br.gov.sp.fatec.mapskills.domain.skill;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6714152121331987401L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ski_id")
	private Integer id;
	
	@Column(name = "ski_description", nullable = false)
	private String description;
	
	public Skill() {}
	
	public Skill(final String description) {
		this.description = description;
	}
	
	public Integer id() {
		return id;
	}
	
	public String description() {
		return description;
	}
	
	public void changeDescription(final String newDescription) {
		this.description = newDescription;
	}

}
