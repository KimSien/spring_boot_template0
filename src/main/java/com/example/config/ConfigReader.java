package com.example.config;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConfigReader {


	@Autowired
	private Settings settings;
	
	public String getHost(){
        Map<String, String> map = settings.getMail();
        return map.get("host");		
	}
	
	public String getUsername(){
        Map<String, String> map = settings.getMail();
        return map.get("username");		
	}
	
	public String getPassword(){
		Map<String,String> map = settings.getMail();
		return map.get("password");
	}
	
	
	
}
