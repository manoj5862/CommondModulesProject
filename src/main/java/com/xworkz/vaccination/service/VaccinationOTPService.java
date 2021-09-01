package com.xworkz.vaccination.service;

public interface VaccinationOTPService {
boolean onVaccinationOTPSend(String email);
boolean validateEmail(String email);
boolean verifyEmailFromDB(String email);
boolean verifyOTP(Integer otp);
}
