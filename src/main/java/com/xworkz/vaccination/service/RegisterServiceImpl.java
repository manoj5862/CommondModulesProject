package com.xworkz.vaccination.service;

import java.util.*;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.util.PasswordEncryptorAndDecryptor;
import com.xworkz.vaccination.dto.RegisterDTO;
import com.xworkz.vaccination.entity.RegisterEntity;
import com.xworkz.vaccination.repository.RegisterDAO;

@Service
public class RegisterServiceImpl implements RegisterService {

	public static Map<String, String> map = new HashMap<String, String>();

	@Autowired
	private RegisterDAO dao;

	@Autowired
	private PasswordEncryptorAndDecryptor encryptDecrypt;

	public RegisterServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean registerServiceValidate(RegisterDTO dto) {
		boolean flag = false;

		if (dto.getUsername() != null && !dto.getUsername().isEmpty() && dto.getEmail() != null
				&& !dto.getEmail().isEmpty() && dto.getPhonenumber() >= 1000000000l && dto.getPhonenumber() != null
				&& dto.getPassword() != null && !dto.getPassword().isEmpty() && dto.getVaccineType() != null
				&& !dto.getCpassword().isEmpty() && dto.getCpassword() != null && !dto.getVaccineType().isEmpty()
				&& dto.getGender() != null && !dto.getGender().isEmpty() && dto.getAge() > 10) {
			flag = true;

		} else {
			map.put("name", "*Name field cant be empty!!!!");
			map.put("email", "*Email field cant be empty!!!!");
			map.put("password", "*Password field cant be empty!!!!");
			map.put("confirmPassword", "*Password field cant be empty!!!!");
			map.put("mobile", "*Invalid Mobile Number!!!!");
			map.put("gender", "*Gender cant be empty!!!!");
			map.put("type", "*Type of field cant be empty!!!!");
			map.put("age", "Invalid Age");
		}
		return flag;
	}

	@Override
	public boolean serviceSave(RegisterDTO dto) {
		System.out.println("Invoked Service Save Mrthod");
		try {
			RegisterEntity entity = new RegisterEntity();
			BeanUtils.copyProperties(dto, entity);
			String encryptedPassword = this.encryptDecrypt.encrypt(dto.getPassword());
			entity.setPassword(encryptedPassword);
			entity.setNoAddMemberCount(0);
			entity.setNoOfLoginAttempts(0);
			boolean outcome = this.dao.regsiterDao(entity);
			if (outcome) {
				System.out.println("Saved the deatils into db");
				return true;
			} else {
				System.out.println("Details are not saved into db");
				return false;

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an Exception " + e.getMessage());
		}
		return false;
	}

	

}
