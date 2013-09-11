package com.epf.computerdatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epf.computerdatabase.dao.ComputerDAO;
 
@Service
public class ComputerService implements iService {
 
    @Autowired
    private ComputerDAO computerDAO;
     
    @Transactional
    public void add(Object obj) {
    	computerDAO.add(obj);
    }
 
    @Transactional
    public List<Object> listObjects() {
 
        return computerDAO.listObjects();
    }
 
    @Transactional
    public void remove(Integer id) {
    	computerDAO.remove(id);
    }
}
