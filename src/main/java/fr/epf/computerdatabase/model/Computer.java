package fr.epf.computerdatabase.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@NamedQueries ({
	@NamedQuery(name= Computer.FIND_ALL,query="SELECT c FROM Computer c"),
	@NamedQuery(name= Computer.COUNT_ALL,query="SELECT COUNT(c) FROM Computer c"),
	@NamedQuery(name=Computer.FIND_BY_NAME,query="SELECT c FROM Computer c WHERE lower(c.name) = lower(:name)"),
	@NamedQuery(name=Computer.DELETE,query="DELETE FROM Computer c WHERE c.id LIKE :id")
})
@Table(name="computer")
public class Computer {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date introduced;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date discontinued;
	
	private Company company;
	
	public static final String FIND_ALL =  "Computer.findAll";
	public static final String COUNT_ALL =  "Computer.countAll";
	public static final String FIND_BY_NAME = "Computer.findByName";
	public static final String DELETE = "Computer.delete";
	
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduced() throws ParseException {
		String datestr = "";
		if(introduced != null) {
			datestr = format.format(introduced);
		}
		return datestr;	
	}
	public void setIntroduced(Timestamp introduced) {		
		this.introduced = introduced;	
	}
	public String getDiscontinued() {
		String datestr = "";
		if(discontinued != null) {
			datestr = format.format(discontinued);
		}
		return datestr;
	}
	public void setDiscontinued(Timestamp discontinued) {
		this.discontinued = discontinued;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String toString(){
		return "Computer:/n"
				+"name: "+this.name
				+"introduced: "+this.introduced
				+"discontinued: "+this.discontinued
				+"company: "+this.company.getName();
	}
}

