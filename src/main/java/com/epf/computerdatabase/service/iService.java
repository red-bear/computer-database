package com.epf.computerdatabase.service;

import java.util.List;
 
public interface iService {     
    public void add(Object obj);
    public List<Object> listObjects();
    public void remove(Integer id);
}