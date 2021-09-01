package com.xworkz.vaccination.repository;

import java.util.List;

import com.xworkz.vaccination.entity.AddMemberEntity;

public interface EditMemberDAO {
List<AddMemberEntity> getListOfMembers(); 
void updateRecordByName(AddMemberEntity addMemberEntity);
}
