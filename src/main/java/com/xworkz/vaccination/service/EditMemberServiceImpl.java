package com.xworkz.vaccination.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.dto.AddMemberDTO;
import com.xworkz.vaccination.entity.AddMemberEntity;
import com.xworkz.vaccination.repository.EditMemberDAO;

@Service
public class EditMemberServiceImpl implements EditMemberService {
	
	@Autowired
	private EditMemberDAO editMemberDAO;

	public EditMemberServiceImpl() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@Override
	public List<Object> getListOfEditMember() {
    List<AddMemberEntity> listOfAddMembers = this.editMemberDAO.getListOfMembers();
    if (listOfAddMembers != null) {
    	System.out.println("Records Fetched Successfully");
		return new ArrayList<Object>(listOfAddMembers);
	}
		return null;
	}

	@Override
	public List<Object> updateRecordByName(AddMemberDTO addMemberDTO) {
		System.out.println("Invoked updateRecordByName");
		AddMemberEntity addMemberEntity = new AddMemberEntity();
		BeanUtils.copyProperties(addMemberDTO, addMemberEntity);
		this.editMemberDAO.updateRecordByName(addMemberEntity);
		List<AddMemberEntity> listOfAddMembers = this.editMemberDAO.getListOfMembers();
	    if (listOfAddMembers != null) {
	    	System.out.println("Records Fetched Successfully");
			return new ArrayList<Object>(listOfAddMembers);
		}
		return null;
	}

}
