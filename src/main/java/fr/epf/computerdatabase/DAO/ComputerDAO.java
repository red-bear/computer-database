package fr.epf.computerdatabase.DAO;

import java.util.List;

import fr.epf.computerdatabase.model.Computer;

public interface ComputerDAO {
	void addComputer(Computer comp);
	Computer getComputerById(long id);
	void updateComputer(Computer comp);
	List<Computer> getAllComputers();
	long countAllComputers();
	List<Computer> getComputersByName(String name);
	void deleteComputer(Long id);
}