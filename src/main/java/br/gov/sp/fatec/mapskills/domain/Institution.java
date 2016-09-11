package br.gov.sp.fatec.mapskills.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "institution")
public class Institution {
	@Id
	@GeneratedValue
	@Column(name = "ins_id")
	private Integer id;
	@Column(name = "ins_cnpj", nullable = true, unique = true)
	private String cnpj;
	@Column(name = "ins_company", nullable = true)
	private String company;
	@Column(name = "ins_city", nullable = true)
	private String city;

	public Institution() {}
	
	public Institution(final String cnpj, final String company, final String city) {
		this.cnpj = cnpj;
		this.company = company;
		this.city = city;
	}
	
}
