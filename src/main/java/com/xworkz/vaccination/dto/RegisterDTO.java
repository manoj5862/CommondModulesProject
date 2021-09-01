package com.xworkz.vaccination.dto;

public class RegisterDTO {
	private String username;
	private String email;
	private int age;
	private String password;
	private String cpassword;
	private Long phonenumber;
	private String gender;
	private String vaccineType;

	public RegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterDTO(String username, String email, int age, String password, String cpassword, Long phonenumber,
			String gender, String vaccineType) {
		super();
		this.username = username;
		this.email = email;
		this.age = age;
		this.password = password;
		this.cpassword = cpassword;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.vaccineType = vaccineType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	@Override
	public String toString() {
		return "RegisterDTO [username=" + username + ", email=" + email + ", age=" + age + ", password=" + password
				+ ", cpassword=" + cpassword + ", phonenumber=" + phonenumber + ", gender=" + gender + ", vaccineType="
				+ vaccineType + "]";
	}
	
	

}
