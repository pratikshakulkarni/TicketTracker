package com.tracker.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tracker.app.model.User;

@Controller
public class TrackerController implements ITrackerController {
	
	@RequestMapping("/")
	public String getLogin(Model theModel) {
		
		User user = new User();
		theModel.addAttribute("user", user);
		
		return "login";
	}
	
	@RequestMapping("/Registration")
	public String showReg() {
				
		return "Registration";
	}
	
	@RequestMapping("/user")
	public String getUser(@ModelAttribute("user") User theUser, Model theModel){
		theModel.addAttribute("username", theUser.getEmail());
		theModel.addAttribute("password", theUser.getPassword());
		System.out.println(theUser.getEmail());
		System.out.println(theUser.getPassword());
		
		return "user";
	}
}
