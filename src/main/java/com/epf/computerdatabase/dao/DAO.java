package com.epf.computerdatabase.dao;

import java.util.List;
 
public interface DAO {     
    public void add(Object obj);
    public List<Object> listObjects();
    public void remove(Integer id);
}
