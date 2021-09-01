package com.xworkz.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.entity.RegisterEntity;
import com.xworkz.vaccination.repository.VaccinationOTPDao;
import com.xworkz.vaccination.util.MailTrigger;
import com.xworkz.vaccination.util.RandomNumberGenerator;

@Service
public class VaccinationOTPServiceImpl implements VaccinationOTPService {

	@Autowired
	private VaccinationOTPDao vaccinationOTPdao1;

	@Autowired
	private MailTrigger mailTrigger;
	
    Integer generatedOtp;

	public VaccinationOTPServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public boolean onVaccinationOTPSend(String email) {
		System.out.println("Invoked onVaccinationOTPSend() ");
		 generatedOtp = RandomNumberGenerator.randomNumberGenerator(1000, 9999);
       boolean outcome = this.mailTrigger.mailTrigger(email, "Vaccination OTP", "Your otp for vaccination is "+generatedOtp);
		if(outcome) {
			return true;
		}
       return false;
	}

	@Override
	public boolean validateEmail(String email) {
		if (email != null && !email.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean verifyEmailFromDB(String email) {
		System.out.println("Invoked verifyEmailFromDB() ");
		RegisterEntity outcome = this.vaccinationOTPdao1.verifyEmailFromDBByEmail(email);
		if (outcome != null  && outcome.getEmail().equals(email)) {

			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean verifyOTP(Integer enteredOtp) {
		System.out.println("Invoked verifyOTP()");
		if (enteredOtp != null && enteredOtp.equals(generatedOtp)) {
			return true;
		} else {
			return false;
		}
		
	}

}
