package com.tracker.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tracker.app.model.User;
import com.tracker.app.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/","/login"}, method=RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		
		model.addObject("user",user);
		model.setViewName("Registration");
		
		return model;
	}
	
	@RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult ) {
		
		ModelAndView model = new ModelAndView();
		
		User userExists = userService.findByEmail(user.getEmail());
		
		if(userExists != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exists");
		}
		
		if(bindingResult.hasErrors()) {
			model.setViewName("Registration");
		}else {
			userService.save(user);
			model.addObject("msg","User is added successfully");
			model.addObject("user",new User());
			model.setViewName("Registration");
		}
		
		return model;
	}
	
	@RequestMapping(value={"/home/home"},method=RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("in Home.html");
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findByEmail(auth.getName());
		
		model.addObject("userName",user.getFirstName() +" "+ user.getLastName());
		model.setViewName("home/home");
		
		return model;
	}

}	





