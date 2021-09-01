package com.xworkz.vaccination.dto;

public class AddMemberDTO {
	private String name;
	private String vaccineType;
	private String gender;
	private Long aadhar;
	
	public AddMemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddMemberDTO(String name, String vaccineType, String gender, Long aadhar) {
		super();
		this.name = name;
		this.vaccineType = vaccineType;
		this.gender = gender;
		this.aadhar = aadhar;
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
		return "AddMemberDTO [name=" + name + ", vaccineType=" + vaccineType + ", gender=" + gender + ", aadhar="
				+ aadhar + "]";
	}
	
	
	
	
	
	
	

}
