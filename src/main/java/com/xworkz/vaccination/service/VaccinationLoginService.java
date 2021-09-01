package com.xworkz.vaccination.service;

import org.springframework.ui.Model;

public interface VaccinationLoginService {
	public boolean loginService(String email , String Password , Model model);
    public boolean loginEmailAndPasswordValidate(String email, String Password);
    boolean validateEmail(String email);
    boolean CheckNoOfLoginAttempts(String email);
}
