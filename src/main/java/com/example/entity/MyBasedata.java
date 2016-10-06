package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MyBasedata {

    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String mail;
    private String memo;
    
    /*
     * lombok でgetter/setter 
     * 
     * */
    
    
    public MyBasedata(){};
    
    @Override
    public String toString() {
        return "MyBasedata [id=" + id + ", Username=" + username + "]";
    }
    
    
	
	
}
