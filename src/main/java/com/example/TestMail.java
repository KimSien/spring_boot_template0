package com.example;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.config.Settings;


@Component
public class TestMail {

	TestMail(){
	}
	
	@Autowired
	private Settings setting;
	
    public String getHost(){
        Map<String, String> map = setting.getMail();
        System.out.println(map.get("host"));
        return map.get("host");
    }
    
	
}
