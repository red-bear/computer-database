package fr.epf.computerdatabase.test;


import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import fr.epf.computerdatabase.controller.ComputersController;
import fr.epf.computerdatabase.model.Company;
import fr.epf.computerdatabase.model.Computer;
import fr.epf.computerdatabase.service.CompanyService;
import fr.epf.computerdatabase.service.ComputerService;

public class ComputersControllerTest {
	@Test
	public void shouldDisplayComputers() {
	List<Computer> expectedComputers = asList(new Computer(), new Computer(), new Computer());
	List<Company> expectedCompanies = asList(new Company(), new Company(), new Company());
	
	ComputerService computerService = mock(ComputerService.class);
	CompanyService companyService = mock(CompanyService.class);
	
	when(computerService.getAllComputers()).
		thenReturn(expectedComputers);
	
	when(companyService.getAllCompanies()).
		thenReturn(expectedCompanies);
	
	ComputersController controller = new ComputersController(computerService, companyService);
	
	//On teste une seule requete pour l'instant
	HashMap<String, Object> model = new HashMap<String, Object>();
	String viewName = controller.showDashboard(model);
	
	assertEquals("dashboard", viewName);
	
	assertSame(expectedComputers, model.get("computers"));
	verify(computerService).getAllComputers();
	
	}
}
