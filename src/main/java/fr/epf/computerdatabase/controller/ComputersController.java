package fr.epf.computerdatabase.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.epf.computerdatabase.service.CompanyService;
import fr.epf.computerdatabase.service.ComputerService;

import javax.inject.Inject;


@Controller
public class ComputersController {
	public static final int DEFAULT_COMPUTERS_PER_PAGE = 25;
	
	private ComputerService computerService;
	private CompanyService companyService;
	
	@Inject
	public ComputersController(ComputerService computerService, CompanyService companyService) {
		this.computerService = computerService;
		this.companyService = companyService;
	}
	
	@RequestMapping({"/","/dashboard","/index"})
	public String showDashboard(Map<String, Object> model) {
		model.put("computers", computerService.getAllComputers());
		model.put("computers_count", computerService.countAllComputers());
		return "dashboard";
	}
	@RequestMapping({"/addcomputer"}) 
	public String addComputerShow(Map<String, Object> model) {
		model.put("companies", companyService.getAllCompanies());
		return "addComputer";
	}

}
