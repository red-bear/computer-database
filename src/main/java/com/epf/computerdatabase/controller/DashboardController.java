package com.epf.computerdatabase.controller;

import java.util.Map;
 
import com.epf.computerdatabase.model.Company;
//import com.epf.computerdatabase.model.Computer;
import com.epf.computerdatabase.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class DashboardController {
 
    @Autowired
    private iService iserv;

    @RequestMapping("/dashboard")
    public String listContacts(Map<String, Object> map) {
 
        map.put("company", new Company());
        map.put("companyList", iserv.listObjects());
 
        return "company";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("company")
    Company company, BindingResult result) {
 
        iserv.add(company);
 
        return "redirect:/dashboard";
    }
 
    @RequestMapping("/delete/{companyId}")
    public String deleteContact(@PathVariable("companyId")
    Integer contactId) {
 
       iserv.remove(contactId);
 
        return "redirect:/dashboard";
    }
}