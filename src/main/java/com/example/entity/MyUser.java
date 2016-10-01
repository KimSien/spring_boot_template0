package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyUser {

    @Id @GeneratedValue
    private Long id;
    private String value;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MyUser(String value) {
        this.value = value;
    }

    public MyUser() {}

    @Override
    public String toString() {
        return "myuser [id=" + id + ", value=" + value + "]";
    }
}