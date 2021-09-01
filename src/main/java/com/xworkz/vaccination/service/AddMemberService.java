package com.xworkz.vaccination.service;

import java.util.List;

import com.xworkz.vaccination.dto.AddMemberDTO;
import com.xworkz.vaccination.entity.AddMemberEntity;

public interface AddMemberService {
boolean ValidateAddMemberDTO(AddMemberDTO addMemberDTO);
List<Object> AddMemberDTOSave(AddMemberDTO addMemberDTO);
boolean checkAddMemberCount(String EmailId);

}
