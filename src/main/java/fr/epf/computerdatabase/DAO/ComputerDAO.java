package fr.epf.computerdatabase.DAO;

import java.util.List;

import fr.epf.computerdatabase.model.Computer;

public interface ComputerDAO {
	void addComputer(Computer comp);
	Computer getComputerById(long id);
	void updateComputer(Computer comp, String ancient_name);
	List<Computer> getAllComputers();
	List<Computer> getComputersByName(String name);	
	long countAllComputers();
	void deleteComputer(Long id);
}