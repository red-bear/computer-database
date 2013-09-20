package fr.epf.computerdatabase.controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.epf.computerdatabase.service.CompanyService;
import fr.epf.computerdatabase.service.ComputerService;
import fr.epf.computerdatabase.model.Computer;

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
	@RequestMapping(value="/searchcomputers", method=RequestMethod.GET)
	public String searchComputers(@RequestParam("search") String name, Map<String, Object> model) {
		List<Computer> list;
		System.out.println("nom: "+name);
		if(name==null||name==""){
			return showDashboard(model);
		}
		list = computerService.getComputersByName(name);
		model.put("computers", list);
		model.put("computers_count", list.size());
		return "dashboard";
	}
	
	@RequestMapping({"/editcomputer"})
	public String editComputer(@RequestParam("id") Long id, Map<String, Object> model){
		Computer comp = computerService.getComputerById(id);
		model.put("companies", companyService.getAllCompanies());
		System.out.println("computer: "+comp.getName());
		model.put("computer", comp);
		return "addComputer";
	}
	
	@RequestMapping({"/deletecomputer"})
	public String deleteComputer(@RequestParam("id") Long id, Map<String, Object> model){
		computerService.deleteComputer(id);
		return showDashboard(model);
	}
	
	@RequestMapping(value="/addcomputerpost", method=RequestMethod.POST)
	public String addComputer(@RequestParam("name") String name,
			@RequestParam("introducedDate") Date introduced,
			@RequestParam("discontinuedDate") Date discontinued,
			@RequestParam("company") Long id,
			Map<String, Object> model) {
		System.out.println("nom: "+name);
		return showDashboard(model);
	}

}
