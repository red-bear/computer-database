package com.epf.computerdatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epf.computerdatabase.dao.CompanyDAO;
 
@Service
public class CompanyService implements iService {
 
    @Autowired
    private CompanyDAO companyDAO;
     
    @Transactional
    public void add(Object obj) {
    	companyDAO.add(obj);
    }
 
    @Transactional
    public List<Object> listObjects() {
 
        return companyDAO.listObjects();
    }
 
    @Transactional
    public void remove(Integer id) {
        companyDAO.remove(id);
    }
}