package com.example;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@EnableAutoConfiguration
public class BaseController{

	@RequestMapping("/base")
	public String Output(HttpServletRequest request,
            HttpStatus status,Model model){
		System.out.println(request.getParameter("name"));

		model.addAttribute("title", "titlehakoredesu");
		model.addAttribute("values","testmodeldesuyo");
		return "base";

	}
	
}
