package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@EnableAutoConfiguration
public class FirstController {

	@RequestMapping("/login")
	public String logindesu(Model model){
		
		model.addAttribute("title","testmodeldesuyo");
		return "login";
	}
	
}
