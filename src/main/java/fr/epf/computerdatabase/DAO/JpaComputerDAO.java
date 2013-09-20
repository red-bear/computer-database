package fr.epf.computerdatabase.DAO;

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
	
	public void addComputer(Computer comp) {
		em.persist(comp);
	}
	
	public Computer getComputerById(long id) {
		return em.find(Computer.class, id);
	}
	
	public void updateComputer(Computer comp) {
		em.merge(comp);
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

}
