package com.xworkz.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.vaccination.dto.RegisterDTO;
import com.xworkz.vaccination.dto.ResetPasswordDTO;
import com.xworkz.vaccination.service.ResetPasswordService;

@Controller
public class ResetPasswordController {

	@Autowired
	private ResetPasswordService resetPasswordService;

	public ResetPasswordController() {
		System.out.println("Invoked " + this.getClass().getSimpleName());
	}

	@RequestMapping("/reset.do")
	public String onGetResetPage() {
		System.out.println("Invoked onGetResetPage");
		return "ResetPassword";
	}
     @RequestMapping(value = "/resetpassword.do", method = RequestMethod.POST )
	public String onResetPassword(@ModelAttribute ResetPasswordDTO resetPasswordDTO, Model model) {
		System.out.println("Invoked onResetPassword");
		boolean result = this.resetPasswordService.ValidateResetPasswordDTO(resetPasswordDTO);
        if (result) {
		boolean outcome = this.resetPasswordService.resetPassword(resetPasswordDTO.getEmail(), resetPasswordDTO.getPassword());
		if (outcome) {
		boolean resetNoOfLoginAttempts = this.resetPasswordService.resetNoOfLoginAttempts(resetPasswordDTO.getEmail());
		if (resetNoOfLoginAttempts) {
			model.addAttribute("ResetPasswordMessage", "Successfully Reset the password.. Login Again");
			return "Login";	
		}
		}
		}else {
			model.addAttribute("ResetPasswordMessage", "Email or Password Cannot be Empty");
			return "ResetPassword";
		}
		return null;
		
	}
}
