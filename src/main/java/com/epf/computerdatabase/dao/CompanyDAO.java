package com.epf.computerdatabase.dao;

import java.util.List;

import com.epf.computerdatabase.model.Company;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class CompanyDAO implements DAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void add(Object obj) {
    	Company company = (Company) obj;
        sessionFactory.getCurrentSession().save(company);
    }
 
    @SuppressWarnings("unchecked")
	public List<Object> listObjects() {
 
        return sessionFactory.getCurrentSession().createQuery("from company")
                .list();
    }
 
    public void remove(Integer id) {
    	Company company = (Company) sessionFactory.getCurrentSession().load(
    			Company.class, id);
        if (null != company) {
            sessionFactory.getCurrentSession().delete(company);
        }
 
    }
}
