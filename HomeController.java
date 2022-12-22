package com.controller;
	// HomeController.java
	
    import org.springframework.security.access.prepost.PreAuthorize;  
	import org.springframework.stereotype.Controller;    
	import org.springframework.web.bind.annotation.RequestMapping;    
	import org.springframework.web.bind.annotation.RequestMethod;  
	import org.springframework.web.bind.annotation.ResponseBody;  
	@Controller    
    public class HomeController {    
	@RequestMapping(value="/", method=RequestMethod.GET)    
	public String index() {    
	return "index";    
	 }    
	@RequestMapping(value="/user", method=RequestMethod.GET)    
	 public String user() {    
	 return "admin";  
	}    
	@RequestMapping(value="/admin", method=RequestMethod.GET)    
	public String admin() {    
	return "admin";    
	}  
	// Only, a person having ADMIN role can access this method.  
    @RequestMapping(value="/update", method=RequestMethod.GET)   
	@ResponseBody  
	@PreAuthorize("hasRole('ROLE_ADMIN')")  
	public String update() {    
    return "record updated ";    
	 }  
	}   


