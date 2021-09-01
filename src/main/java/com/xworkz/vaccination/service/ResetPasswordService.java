package com.xworkz.vaccination.service;

import com.xworkz.vaccination.dto.ResetPasswordDTO;

public interface ResetPasswordService {
boolean ValidateResetPasswordDTO(ResetPasswordDTO resetPasswordDTO);
boolean resetPassword(String email, String password);
boolean resetNoOfLoginAttempts(String email);
}
