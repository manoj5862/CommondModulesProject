package com.xworkz.vaccination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccination.service.DeleteMemberService;
import com.xworkz.vaccination.service.EditMemberService;

@Controller
public class DeleteMemberController {

	@Autowired
	private EditMemberService editMemberService;

	@Autowired
	private DeleteMemberService deleteMemberService;

	public DeleteMemberController() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@RequestMapping("/DeleteMemberPage.do")
	public String OnDeletePage(Model model) {
		System.out.println("Invoked OnDeletePage");
		List<Object> listOfAddMembers = this.editMemberService.getListOfEditMember();
		model.addAttribute("ListOfAddedMembers", listOfAddMembers);
		return "DeleteMember";
	}
   @RequestMapping("/DeleteMembers.do")
	public String deleteMember(@RequestParam String name, Model model) {
		System.out.println("Invoked deleteMember");
		boolean result = this.deleteMemberService.deleteMemberService(name);
		if (result) {
			List<Object> listOfAddMembers = this.editMemberService.getListOfEditMember();
			model.addAttribute("ListOfAddedMembers", listOfAddMembers);
			return "DeleteMember";
		}
		return null;
	}
}
