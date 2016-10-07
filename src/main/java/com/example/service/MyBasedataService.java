package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.example.entity.MyBasedata;
import com.example.jpa.MyBaseRepository;
 
import java.util.List;


@Service
@Transactional
public class MyBasedataService {
	
	  @Autowired
	  MyBaseRepository mybaseRepository;
	   
	  public List<MyBasedata> findAll() {
	    return mybaseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	  }
	   
	  public MyBasedata save(MyBasedata mybasedata) {
	    return mybaseRepository.save(mybasedata);
	  }
	   
	  public void delete(Long id) {
		  mybaseRepository.delete(id);
	  }
	   
	  public MyBasedata find(Long id) {
	        return mybaseRepository.findOne(id);
	    }
	
	
	
	
	
	
	
	

}