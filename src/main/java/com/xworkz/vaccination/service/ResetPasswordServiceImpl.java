package com.xworkz.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.dto.ResetPasswordDTO;
import com.xworkz.vaccination.repository.ResetPasswordDAO;
import com.xworkz.vaccination.util.PasswordEncryptorAndDecryptor;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {
	
	@Autowired
	private PasswordEncryptorAndDecryptor passwordEncryptDecrypt;

	@Autowired
	private ResetPasswordDAO resetPasswordDAO;

	public ResetPasswordServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean ValidateResetPasswordDTO(ResetPasswordDTO resetPasswordDTO) {
		if (!resetPasswordDTO.getEmail().isEmpty() && resetPasswordDTO.getEmail() != null
				&& !resetPasswordDTO.getPassword().isEmpty() && resetPasswordDTO.getPassword() != null
				&& !resetPasswordDTO.getConfirmpassword().isEmpty() && resetPasswordDTO.getConfirmpassword() != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean resetPassword(String email, String password) {
	String encryptPassword = this.passwordEncryptDecrypt.encrypt(password);
		boolean result = this.resetPasswordDAO.resetPasswordByEmailId(email, encryptPassword);
		if (result) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean resetNoOfLoginAttempts(String email) {
		int noOfLoginAttempts = 0;
		boolean result = this.resetPasswordDAO.resetNoOfLoginAttemptsByEmail(email, noOfLoginAttempts);
		if (result) {
			return true;
		} else {
			return false;
		}

	}

}
