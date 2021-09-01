package com.xworkz.vaccination.service;

import java.util.List;

import com.xworkz.vaccination.dto.AddMemberDTO;

public interface EditMemberService {
public List<Object> getListOfEditMember(); 
public List<Object> updateRecordByName(AddMemberDTO addMemberDTO);
}
