package fr.epf.computerdatabase.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.epf.computerdatabase.model.Company;

@Repository("companyDAO")
@Transactional
public class JpaCompanyDAO implements CompanyDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Company> getAllCompanies() {
		Query query = em.createNamedQuery(Company.FIND_ALL);
		return query.getResultList();
	}
}
