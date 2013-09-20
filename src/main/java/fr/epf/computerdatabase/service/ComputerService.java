package fr.epf.computerdatabase.service;

import java.util.List;

import fr.epf.computerdatabase.model.Computer;

public interface ComputerService {
	
	void addComputer(Computer comp);
	Computer getComputerById(long id);
	void updateComputer(Computer comp);
	List<Computer> getAllComputers();
	long countAllComputers();
	List<Computer> getComputersByName(String name);
	void deleteComputer(Long id);
}
