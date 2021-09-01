package com.xworkz.vaccination.repository;

public interface ResetPasswordDAO {

	boolean resetPasswordByEmailId(String email, String password);

	boolean resetNoOfLoginAttemptsByEmail(String email, int noOfLoginAttempts);
}
