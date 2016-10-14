package com.example.jpa;

import com.example.entity.MyBasedata;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MyBaseRepository  extends JpaRepository<MyBasedata, Long>{

	public MyBasedata findByUsername(String username);

}

