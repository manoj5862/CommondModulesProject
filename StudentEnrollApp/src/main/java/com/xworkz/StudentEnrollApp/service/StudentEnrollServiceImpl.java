package com.xworkz.StudentEnrollApp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.StudentEnrollApp.dto.StudentEnrollDTO;
import com.xworkz.StudentEnrollApp.entity.StudentEnrollEntity;
import com.xworkz.StudentEnrollApp.repository.StudentEnrollRepository;
import com.xworkz.StudentEnrollApp.util.RandomPasswordGenerator;

@Service
public class StudentEnrollServiceImpl implements StudentEnrollService {

	@Autowired
	private StudentEnrollRepository enrollRepository;
    @Autowired
	private JavaMailSender mailSender;
	public StudentEnrollServiceImpl() {
		System.out.println("Created "+this.getClass().getSimpleName());
	}

	@Override
	public boolean saveStudentDetails(StudentEnrollDTO studentEnrollDTO) {
		System.out.println("Invoked SaveDetailsOf Service method");
		StudentEnrollEntity enrollEntity = new StudentEnrollEntity(); 
        String randomPassword = RandomPasswordGenerator.generateRandomPassword(6);
        enrollEntity.setPassword(randomPassword);
		BeanUtils.copyProperties(studentEnrollDTO, enrollEntity);
	    boolean outcome = this.enrollRepository.SaveToDb(enrollEntity);
	    if(outcome) {
		System.out.println("saved the details send a mail");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(studentEnrollDTO.getEmail());
		mailMessage.setSubject("Enrollment Message");
		mailMessage.setText("Enrollment Successfull");
		this.mailSender.send(mailMessage);
		return true;
	}else {
		System.out.println("Details not saved dont send the mail");
		return false;
	}
		
	}

}
