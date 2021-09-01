package com.xworkz.vaccination.repository;

import com.xworkz.vaccination.entity.RegisterEntity;

public interface VaccinationOTPDao {
RegisterEntity verifyEmailFromDBByEmail(String email);
}
