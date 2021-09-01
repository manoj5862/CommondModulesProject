package com.xworkz.vaccination.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccination.dto.RegisterDTO;
import com.xworkz.vaccination.service.RegisterService;
import com.xworkz.vaccination.service.RegisterServiceImpl;
import com.xworkz.vaccination.util.MailTrigger;
import com.xworkz.vaccination.util.RandomNumberGenerator;

@Controller
public class RegisterController {
	Map<String, String> map = RegisterServiceImpl.map;
	@Autowired
	private RegisterService registerService;

	@Autowired
	private MailTrigger mailTrigger;

	public RegisterController() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	@RequestMapping("/Register.do")
	public String onRegister(@ModelAttribute RegisterDTO dto, Model model) {

		System.out.println("Invoked onRegister Method");
		boolean outcome = this.registerService.registerServiceValidate(dto);
		if (outcome) {
			this.registerService.serviceSave(dto);
			return "Login";
		} else if (!map.get("name").isEmpty() && dto.getUsername().isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("name"));
			return "Register";
		}else if (!map.get("email").isEmpty() && dto.getEmail().isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("email"));
			return "Register";
		}
		else if (!map.get("password").isEmpty() && dto.getPassword().isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("password"));
			return "Register";
		}
		else if (!map.get("mobile").isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("mobile"));
			return "Register";
		}
		else if (!map.get("gender").isEmpty() && dto.getGender().isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("gender"));
			return "Register";
		}
		else if (!map.get("type").isEmpty() && dto.getVaccineType().isEmpty()) {
		    model.addAttribute("ErrorMessage", map.get("type"));
			return "Register";
		}
		else if (!map.get("type").isEmpty() && dto.getVaccineType().isEmpty()) {
		    model.addAttribute("ErrorMessage", map.get("type"));
			return "Register";
		}
		else if (!map.get("age").isEmpty() && dto.getVaccineType().isEmpty()) {
		    model.addAttribute("ErrorMessage", map.get("age"));
			return "Register";
		}
		else if (!map.get("confirmPassword").isEmpty() && dto.getVaccineType().isEmpty()) {
		    model.addAttribute("ErrorMessage", map.get("confirmPassword"));
			return "Register";
		}
		
		return null;
	}

}
