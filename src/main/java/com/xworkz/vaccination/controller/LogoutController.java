package com.xworkz.vaccination.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	public LogoutController() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}
	
	 @RequestMapping("/logout.do")
	    public String logout(HttpServletRequest request){
	        request.getSession().invalidate();
	        return "Login";
	    }
	}

