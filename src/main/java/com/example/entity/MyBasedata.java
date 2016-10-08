package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
//@Data
public class MyBasedata {

    @Id
    @GeneratedValue
    private Long id;
    
    private String username;
    
    private String password;
    
    private String mail;
    
    private String memo;
    
    /*
     * lombok でgetter/setter 
     * 
     * */
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public MyBasedata(){};
    
    @Override
    public String toString() {
        return "MyBasedata [id=" + id + ", Username=" + username + "]";
    }
    
    
	
	
}
