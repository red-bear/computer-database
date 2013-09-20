package fr.epf.computerdatabase.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.epf.computerdatabase.model.Computer;

@Repository("computerDAO")
@Transactional
public class JpaComputerDAO implements ComputerDAO {
	
	@PersistenceContext
	private EntityManager em;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public void addComputer(Computer comp) {
		em.persist(comp);
	}
	
	public Computer getComputerById(long id) {
		return em.find(Computer.class, id);
	}
	
	public void updateComputer(Computer comp, String ancient_name) {
		Query update_query=em.createNamedQuery(Computer.UPDATE);
		try {
			update_query.setParameter(1, comp.getName());
			update_query.setParameter(2, format.parse(comp.getIntroduced()));
			update_query.setParameter(3, format.parse(comp.getDiscontinued()));
			update_query.setParameter(4, comp.getCompany());
			update_query.setParameter(5, ancient_name);
			update_query.executeUpdate();
		} catch (ParseException e) {}
	}
	
	@SuppressWarnings("unchecked")
	public List<Computer> getAllComputers() {
		Query query = em.createNamedQuery(Computer.FIND_ALL);
		return query.getResultList();
	}
	
	public long countAllComputers() {
		Query query = em.createNamedQuery(Computer.COUNT_ALL);
		return (long) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersByName(String name) {
		Query query = em.createNamedQuery(Computer.FIND_BY_NAME).setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public void deleteComputer(Long id) {
		Query query = em.createNamedQuery(Computer.DELETE).setParameter("id", id);
		query.executeUpdate();
	}

}
