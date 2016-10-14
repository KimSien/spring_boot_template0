package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	  //public PageRequest(int page, int size);
	  
	  
	  public List<MyBasedata> findMax() {
		  //return mybaseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
		  return mybaseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	  }

	  public List<MyBasedata> findMax2() {
		  //return mybaseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
		  return mybaseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	  }
	  
	  
	  public Page<MyBasedata> findPage(int size, int page) {
		    int start = page * size;
		    return mybaseRepository.findAll(new PageRequest(page,size));
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

	  public MyBasedata findbyusername(String username) {
	        return mybaseRepository.findByUsername(username);
	  }
 
	  
	
	
	
	
	
	
	

}
