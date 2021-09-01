package com.xworkz.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccination.entity.RegisterEntity;
import com.xworkz.vaccination.repository.VaccinationLoginDAO;
import com.xworkz.vaccination.util.EmailValidator;
import com.xworkz.vaccination.util.PasswordEncryptorAndDecryptor;

@Service
public class VaccinationLoginServiceImpl implements VaccinationLoginService {

	@Autowired
	VaccinationLoginDAO vaccinationLoginDAO;

	@Autowired
	private PasswordEncryptorAndDecryptor encryptDecrypt;

	public static String UserName;

	public static String emailId;

	public VaccinationLoginServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean loginService(String email, String Password, Model model) {
		System.out.println("Invoked Login Service Method");
		try {
			RegisterEntity entity = this.vaccinationLoginDAO.getEmailByEntity(email);

			String decryptedPassword = this.encryptDecrypt.decrypt(entity.getPassword());
			if (entity != null && !entity.getEmail().isEmpty() && entity.getEmail() != null
					&& !entity.getPassword().isEmpty() && entity.getPassword() != null
					&& Password.equals(decryptedPassword)) {
				UserName = entity.getUsername();
				emailId = entity.getEmail();
				return true;
			} else {
				Integer loginAttempts = entity.getNoOfLoginAttempts();
				loginAttempts++;
				this.vaccinationLoginDAO.updateAttempt(loginAttempts, email);

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("You have an Exception " + e.getMessage());
			return false;
		}

	}

	@Override
	public boolean loginEmailAndPasswordValidate(String email, String Password) {
		if (!email.isEmpty() && email != null && Password != null && !Password.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean validateEmail(String email) {
		boolean outcome = EmailValidator.emailValidate(email);
		if (outcome) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean CheckNoOfLoginAttempts(String email) {
		Integer result = this.vaccinationLoginDAO.getNoOFLoginAttemptsByEmailId(email);
		if (result <= 3) {
			return true;
		} else {
			return false;
		}

	}
}
