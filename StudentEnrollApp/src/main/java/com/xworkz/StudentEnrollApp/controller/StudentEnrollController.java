package com.xworkz.StudentEnrollApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.StudentEnrollApp.dto.StudentEnrollDTO;
import com.xworkz.StudentEnrollApp.service.StudentEnrollService;

@Controller
public class StudentEnrollController {

@Autowired	
private StudentEnrollService enrollService;
	
public StudentEnrollController() {
	System.out.println("Created "+this.getClass().getSimpleName());
}

@RequestMapping("/enroll.do")
public String onEnroll(@ModelAttribute StudentEnrollDTO studentEnrollDTO , Model model ) {
	System.out.println("Invoked  Controller save method");
	boolean saved = this.enrollService.saveStudentDetails(studentEnrollDTO);
	if(saved) {
    model.addAttribute("EnrollMessage", "Student Successfully Enrolled");
    System.out.println("Message Sent Successfully to UI Pge");
    return "EnrollSuccess";
	}else {
	model.addAttribute("EnrollMessage", "Student Enrollment Failed");
	System.out.println("Message not sent to UI Page");
    return "EnrollSuccess";
	}
	
}
}
