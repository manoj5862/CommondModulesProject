package com.xworkz.vaccination.repository;

import com.xworkz.vaccination.entity.RegisterEntity;

public interface VaccinationLoginDAO {
	RegisterEntity getEmailByEntity(String email);

	void updateAttempt(int noOfUnsuccesfulLoginAttempts, String email);

	Integer getNoOFLoginAttemptsByEmailId(String mail);
}
