package com.xworkz.vaccination.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccination.dto.AddMemberDTO;
import com.xworkz.vaccination.entity.AddMemberEntity;
import com.xworkz.vaccination.service.AddMemberService;
import com.xworkz.vaccination.service.AddMemberServiceImpl;
import com.xworkz.vaccination.service.EditMemberService;

@Controller
public class EditMemberController {

	Map<String, String> map = AddMemberServiceImpl.map;
	
	@Autowired
	private EditMemberService editMemberService;
	
	@Autowired
	private AddMemberService addMemberService;

	public EditMemberController() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@RequestMapping("/EditMemberPage.do")
	public String onEditMember(Model model) {
		List<Object> listOfAddMembers = this.editMemberService.getListOfEditMember();
		model.addAttribute("ListOfAddedMembers", listOfAddMembers);
		return "EditMemberPage";
	}

	@RequestMapping("/EditMembers.do")
	public String EditMember(@ModelAttribute AddMemberDTO addMemberDTO, Model model) {
		System.out.println("Invoked EditMember");
		boolean outcome = this.addMemberService.ValidateAddMemberDTO(addMemberDTO);
		if (outcome) {
			List<Object> listOfAddMembers = this.editMemberService.updateRecordByName(addMemberDTO);
			model.addAttribute("ListOfAddedMembers", listOfAddMembers);
			return "EditMemberPage";
		} else if ( addMemberDTO.getName().isEmpty() ) {
			model.addAttribute("ErrorMessage", map.get("name"));
			return "EditMemberPage";
		} else if (addMemberDTO.getGender().isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("gender"));
			return "EditMemberPage";
		} else if (addMemberDTO.getVaccineType().isEmpty()) {
			model.addAttribute("ErrorMessage", map.get("type"));
			return "EditMemberPage";
		} else if (addMemberDTO.getAadhar() != null) {
			model.addAttribute("ErrorMessage", map.get("aadhaar"));
			return "EditMemberPage";

		}
		return null;
	}

}
