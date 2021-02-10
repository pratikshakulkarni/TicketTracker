package com.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tracker.entity.User;

@Controller
public class TrackerController implements ITrackerController {
	
	@RequestMapping("/")
	public String getLogin(Model theModel) {
		
		User user = User.builder().build();
		theModel.addAttribute("user", user);
		
		return "login";
	}
	
	@RequestMapping("/Registration")
	public String showReg() {
				
		return "Registration";
	}
	
	@RequestMapping("/user")
	public String getUser(@ModelAttribute("user") User theUser, Model theModel){
		theModel.addAttribute("username", theUser.getUsername());
		theModel.addAttribute("password", theUser.getPassword());
		System.out.println(theUser.getUsername());
		System.out.println(theUser.getPassword());
		
		return "user";
	}
}
