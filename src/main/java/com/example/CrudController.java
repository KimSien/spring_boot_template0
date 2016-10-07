package com.example;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.MyBasedata;
import com.example.service.MyBasedataService;

//@Controller
//@EnableAutoConfiguration

@RestController
@RequestMapping("/crud")
public class CrudController{


	/*
	public String Output(HttpServletRequest request,
            HttpStatus status,Model model){
		System.out.println(request.getParameter("name"));

		model.addAttribute("title", "titlehakoredesu");
		model.addAttribute("values","testmodeldesuyo");
		return "base";

	}
	*/
	
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MyBasedata insertmybasedata(@Validated @RequestBody MyBasedata mybasedata) {
        return MyBasedataService.save(mybasedata);
    }
}


