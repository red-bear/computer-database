package fr.epf.computerdatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import fr.epf.computerdatabase.model.Computer;
import fr.epf.computerdatabase.DAO.ComputerDAO;

@Component("computerService")
@Transactional(propagation=Propagation.REQUIRED)
public class ComputerServiceImpl implements ComputerService {
	
	@Autowired
	ComputerDAO computerDAO;
	
	public void addComputer(Computer comp) {
		if(comp.getId() == null) {
			computerDAO.addComputer(comp);
		} else {
			computerDAO.updateComputer(comp);
		}
	}
	
	public Computer getComputerById(long id) {
		return computerDAO.getComputerById(id);
	}
	
	public void updateComputer(Computer comp) {
		computerDAO.updateComputer(comp);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Computer> getAllComputers() {
		return	computerDAO.getAllComputers();
	}
	
	public long countAllComputers() {
		return computerDAO.countAllComputers();
	}
	
	public List<Computer> getComputersByName(String name) {
		return computerDAO.getComputersByName(name);
	}
	
	public void deleteComputer(Long id){
		computerDAO.deleteComputer(id);
	}
}