package fr.epf.computerdatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import fr.epf.computerdatabase.DAO.CompanyDAO;
import fr.epf.computerdatabase.model.Company;

@Component("companyService")
@Transactional(propagation=Propagation.REQUIRED)
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyDAO companyDAO;
	
	public List<Company> getAllCompanies() {
		return companyDAO.getAllCompanies();
	}
	
	public Company getCompanyById(long id) {
		return companyDAO.getCompanyById(id);
	}
}
