package com.xworkz.vaccination.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "addmember_table")
@NamedQueries({
@NamedQuery(name = "updateAddMemberEntityByName", query = "update AddMemberEntity entity set entity.vaccineType=:vaccineType , entity.gender=:Gender , entity.aadhar=:Aadhaar where entity.name=:nm"),
@NamedQuery(name = "deleteMemberByName", query = "delete from AddMemberEntity entity where entity.name=:nm")
})
public class AddMemberEntity {
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "VACCINETYPE")
	private String vaccineType;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "AADHAAR")
	private Long aadhar;
	
	public AddMemberEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddMemberEntity(int id, String name, String vaccineType, String gender, Long aadhar) {
		super();
		this.id = id;
		this.name = name;
		this.vaccineType = vaccineType;
		this.gender = gender;
		this.aadhar = aadhar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAadhar() {
		return aadhar;
	}

	public void setAadhar(Long aadhar) {
		this.aadhar = aadhar;
	}

	@Override
	public String toString() {
		return "AddMemberEntity [id=" + id + ", name=" + name + ", vaccineType=" + vaccineType + ", gender=" + gender
				+ ", aadhar=" + aadhar + "]";
	}
	
	
	
	
	
}
