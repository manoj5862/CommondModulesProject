package com.xworkz.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.repository.DeleteMemberDAO;

@Service
public class DeleteMemberServiceImpl implements DeleteMemberService {

	@Autowired
	private DeleteMemberDAO dao;

	public DeleteMemberServiceImpl() {
		System.out.println("Invoked " + this.getClass().getSimpleName());
	}

	@Override
	public boolean deleteMemberService(String name) {
		System.out.println("Invoked deleteMemberService");
		boolean result = this.dao.deleteMemberByName(name);
		System.out.println("Deleted Successfully");
		if (result) {
			return true;
		}
		return false;
	}

}
