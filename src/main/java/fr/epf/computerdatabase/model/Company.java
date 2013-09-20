package fr.epf.computerdatabase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name= Company.FIND_ALL,query="SELECT c FROM Company c")
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	public static final String FIND_ALL =  "Company.findAll";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
