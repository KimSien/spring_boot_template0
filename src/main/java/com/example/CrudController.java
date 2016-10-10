package com.example;

//import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	MyBasedataService mybasedataService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String showtmybasedata(Model model) {    
    	model.addAttribute("mybasedata", new MyBasedata());
    	return "crud";
    }
	
	
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String insertMybasedata(@RequestBody @ModelAttribute("mybasedata") MyBasedata mybasedata) {
    	mybasedataService.save(mybasedata);
    	return "crud";
    }
    
    
    
    @RequestMapping(value = "/delete/{id}")
    //@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.OK)
    public String deleteMybasedata(@PathVariable("id") Long id) {
    	mybasedataService.delete(id);
    	return "redirect:/crud/all";
    }

    
     
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getMybasedata(@PathVariable("id") Long id,Model model) {
        //return mybasedataService.find(id);
    	model.addAttribute("mybasedata", mybasedataService.find(id));
    	return "crud";
    }
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getMybasedata(Model model) {
        //return mybasedataService.find(id);
    	model.addAttribute("mybasedatas", mybasedataService.findAll());
        
    	return "crud_view";
    }
        
    
    
    
    
    
}


