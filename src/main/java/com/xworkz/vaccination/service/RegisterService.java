package com.xworkz.vaccination.service;

import com.xworkz.vaccination.dto.RegisterDTO;

public interface RegisterService {
	public boolean registerServiceValidate(RegisterDTO dto);
	public boolean serviceSave(RegisterDTO dto);
	
}
