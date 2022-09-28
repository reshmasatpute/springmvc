package com.te.springmvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.springmvc.User;
import com.te.springmvc.service.UserService;

@Controller
public class TestHandler {
	@Autowired
	UserService service;

	@GetMapping("/add")
	public String login() {
		return "login";
	}

	@PostMapping("/inbox")
	public String inbox(@RequestParam String username, @RequestParam String password,Model model) {

		System.out.println(username);
		System.out.println(password);
         List<String> aslist=Arrays.asList("Hello","How are you?","I am fine","Khana khaya kya???");
         model.addAttribute("message", aslist);
		return "register";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		boolean check = service.check(user);
		if (check) {
			return "success";
		}
		return "failure";
	}
	
}
