package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@EnableAutoConfiguration
public class SecondController {

	@RequestMapping("/kim")
	public String KimTaihen(Model model){
		
		model.addAttribute("values","testmodeldesuyo");
		return "kim";
	}
	
}
