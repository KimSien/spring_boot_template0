package com.example;

//import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;

import com.example.entity.MyBasedata;
import com.example.service.MyBasedataService;


//import java.util.List;

@Controller
//@EnableAutoConfiguration

//@RestController
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
	
	@Autowired
	MyBasedataService mybasedataService;

    @RequestMapping(method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus)
    public String showtmybasedata(Model model) {
    	System.out.println("test ----");
    	
    	model.addAttribute("mybasedata", new MyBasedata());
    
    	return "crud";
    }
	
	
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    //@RequestMapping(value = "send", method = RequestMethod.POST)
    public String insertMybasedata(@RequestBody @ModelAttribute("mybasedata") MyBasedata mybasedata) {
    	//System.out.println(mybasedata.getUsername());

    	mybasedataService.save(mybasedata);
    	return "crud";
    }
}


