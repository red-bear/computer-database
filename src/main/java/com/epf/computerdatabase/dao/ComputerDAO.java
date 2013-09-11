package com.epf.computerdatabase.dao;

import java.util.List;

import com.epf.computerdatabase.model.Computer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class ComputerDAO implements DAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void add(Object obj) {
    	Computer computer = (Computer) obj;
        sessionFactory.getCurrentSession().save(computer);
    }
 
    @SuppressWarnings("unchecked")
	public List<Object> listObjects() {
 
        return sessionFactory.getCurrentSession().createQuery("from computer")
                .list();
    }
 
    public void remove(Integer id) {
    	Computer computer = (Computer) sessionFactory.getCurrentSession().load(
    			Computer.class, id);
        if (null != computer) {
            sessionFactory.getCurrentSession().delete(computer);
        }
 
    }
}
