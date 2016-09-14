package br.gov.sp.fatec.mapskills.mentor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "institution")
public class Institution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public void changeCnpj(final String newCnpj) {
		this.cnpj = newCnpj;
	}
	
	public void changeCompany(final String newCompany) {
		this.company = newCompany;
	}
	
	public void changeCity(final String newCity) {
		this.city = newCity;
	}
	
	public String cnpj() {
		return cnpj;
	}
	
	public String company() {
		return company;
	}
	
	public String city() {
		return city;
	}
	
}
