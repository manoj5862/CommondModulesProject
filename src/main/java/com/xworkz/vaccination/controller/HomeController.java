package com.xworkz.vaccination.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.vaccination.dto.AddMemberDTO;
import com.xworkz.vaccination.entity.AddMemberEntity;
import com.xworkz.vaccination.service.AddMemberService;
import com.xworkz.vaccination.service.AddMemberServiceImpl;
import com.xworkz.vaccination.service.VaccinationLoginServiceImpl;

@Controller
public class HomeController {

	Map<String, String> map = AddMemberServiceImpl.map;

	@Autowired
	private AddMemberService addMemberService;

	public HomeController() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@RequestMapping("/AddMemberPage.do")
	public String onGetAddMemberPage() {
		System.out.println("Invoked " + this.getClass().getSimpleName());
		return "AddMember";
	}

	@RequestMapping("/AddMember.do")
	public String onAddMember(@ModelAttribute AddMemberDTO addMemberDTO, Model model) {
		boolean outcome = this.addMemberService.ValidateAddMemberDTO(addMemberDTO);
		if (outcome) {
		boolean checkNoOfAddMemberCount = this.addMemberService.checkAddMemberCount(VaccinationLoginServiceImpl.emailId);
		if(checkNoOfAddMemberCount) {
			List<Object> result = this.addMemberService.AddMemberDTOSave(addMemberDTO);
	        model.addAttribute("SuccessMessage", "Records Fetched SuccessFully");
	    	model.addAttribute("Members", result);
	    	return "HomeSuccess";
		}else {
			model.addAttribute("NoOfMemberCount", "You can add Only Four Members");
			return "HomeSuccess";
		}
	    
		} else if ( addMemberDTO.getName().isEmpty() ) {
			model.addAttribute("ErrorMessage", map.get("name"));
			return "AddMember";
		} else if (addMemberDTO.getGender().isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("gender"));
			return "AddMember";
		} else if (addMemberDTO.getVaccineType().isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("type"));
			return "AddMember";
		} else if (addMemberDTO.getAadhar() != null) {
			model.addAttribute("ErrorMessage", map.get("aadhaar"));
			return "AddMember";

		}
		return null;
	}}